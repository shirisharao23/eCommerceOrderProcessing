package com.egen.ecommerce.ecommerce_order_processing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class EcommerceOrderProcessingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrderProcessingServiceApplication.class, args);
	}

}
