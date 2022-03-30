package com.hjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.hjl")
public class BwEurekaConsumer02Application {

    public static void main(String[] args) {
        System.out.println("消费者02");
        SpringApplication.run(BwEurekaConsumer02Application.class, args);
    }

}
