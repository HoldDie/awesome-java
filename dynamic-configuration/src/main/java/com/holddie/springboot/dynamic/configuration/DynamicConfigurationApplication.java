package com.holddie.springboot.dynamic.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class DynamicConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicConfigurationApplication.class, args);
	}
}
