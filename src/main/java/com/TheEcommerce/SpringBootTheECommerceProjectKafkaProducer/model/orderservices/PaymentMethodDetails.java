package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.model.orderservices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDetails {

        @JsonProperty("card_type")
        private String cardType;

        @JsonProperty("card_number")
        private String cardNumber;

        @JsonProperty("expiry_date")
        private String expiryDate;

        @JsonProperty("billing_address")
        private String billingAddress;
}
