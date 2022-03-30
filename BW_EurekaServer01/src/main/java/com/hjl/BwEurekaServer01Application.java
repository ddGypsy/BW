package com.hjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BwEurekaServer01Application {

    public static void main(String[] args) {
        System.out.println("Eureka01");
        SpringApplication.run(BwEurekaServer01Application.class, args);
    }

}
