package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic theEcommerceProjectCsvTopic(){
        return TopicBuilder.name("the-ecommerce-project-csv-topic").build();
    }

    @Bean
    public NewTopic theEcommerceOrderServicesTopic(){
        return TopicBuilder.name("the-ecommerce-project-orderservices-topic").build();
    }

    @Bean
    public NewTopic theEcommercePaymentBrokerTopic(){
        return TopicBuilder.name("the-ecommerce-project-paymentbroker-topic").build();
    }
}
