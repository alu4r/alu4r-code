package com.alu4r.count;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
public class CountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountServiceApplication.class, args);
	}

}
