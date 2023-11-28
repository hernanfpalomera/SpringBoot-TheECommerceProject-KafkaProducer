package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.controller;


import com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/producers")
public class ProducerController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/csv")
    public void kafkaCsvProducer() {
        //log.info("ProductController::createNewProduct request body {}", ValueMapper.jsonAsString(productRequestDTO));
        kafkaProducerService.processCsvData();
        //log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));
    }

    @GetMapping("/order-services")
    public void kafkaOrderServiceProducer() {
        //log.info("ProductController::createNewProduct request body {}", ValueMapper.jsonAsString(productRequestDTO));
        kafkaProducerService.processOrderServicesFiles();
        //log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));

    }

    @GetMapping("/payment-brokers")
    public void kafkaPaymentBrokerProducer() {
        //log.info("ProductController::createNewProduct request body {}", ValueMapper.jsonAsString(productRequestDTO));
        kafkaProducerService.processPaymentBrokerFiles();
        //log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));

    }


    @GetMapping("/auto-generate/{numberOfOrders}")
    public void kafkaAutoGenerateProducer(@PathVariable Integer numberOfOrders) throws JsonProcessingException {
        //log.info("ProductController::createNewProduct request body {}", ValueMapper.jsonAsString(productRequestDTO));
        kafkaProducerService.processAutoGenerateFiles(numberOfOrders);
        //log.info("ProductController::createNewProduct response {}", ValueMapper.jsonAsString(responseDTO));

    }
}
