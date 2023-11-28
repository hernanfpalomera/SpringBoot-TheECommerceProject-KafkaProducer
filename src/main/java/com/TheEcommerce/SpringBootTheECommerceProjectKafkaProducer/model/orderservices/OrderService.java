package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.orderservices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderService {

    @JsonProperty("purchase_id")
    private String purchaseId;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("customer")
    private Customer customer;

//    @JsonProperty("customer_id")
//    private String customerId;

    @JsonProperty("store_id")
    private String storeId;

    @JsonProperty("creation_date")
    private String creationDate;

    @JsonProperty("products")
    private List<Product> products;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("payment_details")
    private PaymentDetails paymentDetails;

//    @JsonProperty("payment_method_details")
//    private PaymentMethodDetails paymentMethodDetails;

    @JsonProperty("status")
    private String status;
}
