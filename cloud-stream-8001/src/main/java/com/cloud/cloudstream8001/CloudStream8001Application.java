package com.cloud.cloudstream8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.cloud.cloudstream8001.feign")

@SpringBootApplication
public class CloudStream8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStream8001Application.class, args);
    }

}
