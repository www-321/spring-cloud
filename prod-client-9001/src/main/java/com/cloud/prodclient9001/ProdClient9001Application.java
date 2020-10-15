package com.cloud.prodclient9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients(basePackages = "com.cloud.prodclient9001.feign")
@EnableEurekaClient
@SpringBootApplication
public class ProdClient9001Application {

    public static void main(String[] args) {
        SpringApplication.run(ProdClient9001Application.class, args);
    }

}
