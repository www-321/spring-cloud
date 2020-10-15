package com.cloud.prodclient03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.cloud.prodclient03.feign")
@SpringBootApplication
public class ProdClient03Application {

    public static void main(String[] args) {
        SpringApplication.run(ProdClient03Application.class, args);
    }

}
