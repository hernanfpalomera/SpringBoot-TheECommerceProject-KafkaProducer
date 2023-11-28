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
public class Shipment {

    @JsonProperty("shipment_id")
    private String shipmentId;

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("status")
    private String status;

    @JsonProperty("estimated_delivery_date")
    private String estimatedDeliveryDate;
}
