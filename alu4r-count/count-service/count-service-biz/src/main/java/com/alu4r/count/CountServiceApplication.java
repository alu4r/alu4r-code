package com.alu4r.count;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountServiceApplication.class, args);
	}

}