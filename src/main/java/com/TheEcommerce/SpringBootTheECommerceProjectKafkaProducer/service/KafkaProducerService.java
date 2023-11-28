package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaProducerService {

    public void processCsvData();

    public void processOrderServicesFiles();

    public void processPaymentBrokerFiles();

    public void processAutoGenerateFiles(Integer numberOfOrders) throws JsonProcessingException;


}
