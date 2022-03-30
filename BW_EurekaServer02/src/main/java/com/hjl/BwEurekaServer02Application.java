package com.hjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BwEurekaServer02Application {

    public static void main(String[] args) {
        System.out.println("Eureka02");
        SpringApplication.run(BwEurekaServer02Application.class, args);
    }
}
