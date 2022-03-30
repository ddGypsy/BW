package com.hjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.hjl")
@EnableHystrix
public class BwEurekaConsumer01Application {

    public static void main(String[] args) {
        System.out.println("消费者01");
        SpringApplication.run(BwEurekaConsumer01Application.class, args);
    }

}
