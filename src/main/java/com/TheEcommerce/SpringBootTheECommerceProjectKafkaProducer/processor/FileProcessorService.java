package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.processor;

import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.data.RandomDataGenerator;
import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.orderservices.*;
import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.paymentbroker.PaymentBroker;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Component
public class FileProcessorService {

    private static final Random random = new Random();

    private final RandomDataGenerator randomDataGenerator;

    public List<String> listFiles(String folderPath) {
        List<String> filePaths = new ArrayList<>();

        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        filePaths.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return filePaths;
    }


    public List<OrderService> autoGenerateOrderServicesFiles(Integer numberOfOrders) throws JsonProcessingException {
        int processedOrders = 0;
        List<OrderService> orderServiceList = new ArrayList<>();

        while (processedOrders < numberOfOrders) {
            OrderService orderService = generateOrderServicesRandomData();
            orderServiceList.add(orderService);
            processedOrders++;
        }

        return orderServiceList;
    }



    public static OrderService generateOrderServicesRandomData() {
        OrderService orderService = new OrderService();

        // Generate random values for the fields
        orderService.setPurchaseId("PUR" + random.nextInt(100000000));
        orderService.setTimestamp(millisecondsConverter(new Date().getTime()));

        orderService.setCustomer(generateRandomCustomer());
        orderService.setStoreId("STORE" + random.nextInt(1000));
        orderService.setCreationDate(millisecondsConverter(new Date().getTime()));


        // Generate random order lines
        List<Product> products = IntStream.range(0, random.nextInt(10) + 1)
                .mapToObj(i -> {
                    Product product = new Product();
                    product.setProductId("PROD" + random.nextInt(1000));
                    product.setName("Product " + RandomDataGenerator.generateRandomProductName());
                    product.setQuantity(random.nextInt(5) + 1);
                    BigDecimal productPrice = BigDecimal.valueOf(random.nextDouble() * 1000)
                            .setScale(2, RoundingMode.HALF_UP);
                    product.setPrice(productPrice);
                    product.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
                    //orderServiceTotalPrice.add(product.getSubtotal());
                    return product;
                })
                .collect(Collectors.toList());


        orderService.setProducts(products);

        BigDecimal orderServiceTotalPrice = products.stream().map(Product::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);

        orderService.setTotalPrice(orderServiceTotalPrice);
        orderService.setPaymentMethod(RandomDataGenerator.generateRandomPaymentMethodV2());

        PaymentDetails paymentDetails = new PaymentDetails();

        paymentDetails.setCardType(RandomDataGenerator.generateRandomCardBrand());
        paymentDetails.setCardNumber(RandomDataGenerator.generateRandomCardNumber());
        paymentDetails.setExpirationMonth(RandomDataGenerator.generateRandomExpirationMonth());
        paymentDetails.setExpirationYear(RandomDataGenerator.generateRandomExpirationYear());
        paymentDetails.setCvv(RandomDataGenerator.generateRandomCVV());

        orderService.setPaymentDetails(paymentDetails);

        return orderService;
    }


    private static Customer generateRandomCustomer() {

        Customer customer = new Customer();

        customer.setCustomerId(RandomDataGenerator.generateRandomCustomerId());
        customer.setFirstName(RandomDataGenerator.generateRandomFirstName());
        customer.setLastName(RandomDataGenerator.generateRandomLastName());
        customer.setEmail(RandomDataGenerator.generateRandomEmail(customer.getFirstName(), customer.getLastName()));
        customer.setAddress(generateRandomCustomerAddress());
        return customer;
    }

    private static Address generateRandomCustomerAddress() {

        Address address = new Address();

        address.setStreet(RandomDataGenerator.generateRandomStreet());
        address.setCity(RandomDataGenerator.generateRandomCity());
        address.setState(RandomDataGenerator.generateRandomState());
        address.setPostalCode(RandomDataGenerator.generateRandomPostalCode());
        address.setCountry(RandomDataGenerator.generateRandomCountry());
        return address;
    }

    public List<PaymentBroker> autoGeneratePaymentBrokerFiles(List<OrderService> orderServiceList){

        return orderServiceList.stream().map(orderService -> {
            PaymentBroker paymentBroker = new PaymentBroker();

            paymentBroker.setPurchaseId(orderService.getPurchaseId());
            paymentBroker.setPaymentId("PAY" + random.nextInt(1000000000));
            paymentBroker.setAmount(orderService.getTotalPrice());
            paymentBroker.setCardType(orderService.getPaymentDetails().getCardType());
            paymentBroker.setCardNumber(orderService.getPaymentDetails().getCardNumber());
            paymentBroker.setExpiryDate(millisecondsConverter(new Date().getTime()+ (1000 * 60 * 60 * 120)));
            return paymentBroker;
        }).toList();

    }

    private static String millisecondsConverter(long milliseconds) {

        // Convert milliseconds to LocalDateTime
        Instant instant = Instant.ofEpochMilli(milliseconds);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));

        // Format LocalDateTime as string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

        return dateTime.format(formatter);

    }


}
