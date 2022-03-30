package com.hjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class BwWeb01Application {

    public static void main(String[] args) {
        System.out.println("Web");
        SpringApplication.run(BwWeb01Application.class, args);
    }
}
