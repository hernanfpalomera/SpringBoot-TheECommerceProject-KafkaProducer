package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer;


import org.springframework.boot.SpringApplication;


@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

//TODO: Delete the next lines in a future

//	@Bean
//	CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
//		return args -> {
//		kafkaTemplate.send("the-ecommerce-project","Hello kafka");
//		};
//	}

}
