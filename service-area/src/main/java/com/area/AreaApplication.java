package com.area;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/12/16 14:16
 */
@SpringBootApplication(exclude={
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class}
)
public class AreaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AreaApplication.class, args);
    }
}
