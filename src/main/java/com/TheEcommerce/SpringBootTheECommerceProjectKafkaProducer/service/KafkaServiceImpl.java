package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.service;

import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.Sale;
import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.orderservices.OrderService;
import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.paymentbroker.PaymentBroker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaServiceImpl implements KafkaService{

    private final KafkaTemplate<String,String> kafkaTemplate;

    private final Gson gson;

    @Override
    public void publishCsvData(List<Sale> saleList) {
        saleList.forEach(sale ->{
            // Convert the Person object to JSON
            String json = gson.toJson(sale);
            // Print the JSON object
            System.out.println(json);
            kafkaTemplate.send("the-ecommerce-project-csv-topic",json);
        });
    }

    @Override
    public void publishOrderServicesFiles(List<String> orderServicesFilesList) {

        orderServicesFilesList.forEach(filePath ->{
            File file = new File(filePath);

            if(file.getName().contains(".json")) {
                byte[] bytes;
                try {
                    bytes = Files.readAllBytes(file.toPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String json = new String(bytes, StandardCharsets.UTF_8);

                System.out.println(json);

                kafkaTemplate.send("the-ecommerce-project-orderservices-topic", json);
            }
        });

    }

    @Override
    public void publishAutoGeneratedOrderServices(List<OrderService> orderServiceList) {
        orderServiceList.forEach(orderService -> {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String orderServiceJSON = null;
                try {
                    orderServiceJSON = ow.writeValueAsString(orderService);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                kafkaTemplate.send("the-ecommerce-project-orderservices-topic", orderServiceJSON);

        });

        // Shutdown the executorService when you are done with it
    }



    @Override
    public void publishAutoGeneratedPaymentBroker(List<PaymentBroker> paymentBrokerList) {
        paymentBrokerList.forEach(paymentBroker -> {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String paymentBrokerJSON = null;
                try {
                    paymentBrokerJSON = ow.writeValueAsString(paymentBroker);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                kafkaTemplate.send("the-ecommerce-project-paymentbroker-topic", paymentBrokerJSON);
        });

        // Shutdown the executorService when you are done with it
    }

}
