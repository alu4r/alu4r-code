package com.alu4r.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/16 20:49
 */
@SpringBootApplication
@EnableEurekaServer
public class CenterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterServiceApplication.class,args);
    }
}
