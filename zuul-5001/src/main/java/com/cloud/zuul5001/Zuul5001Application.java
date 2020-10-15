package com.cloud.zuul5001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Zuul5001Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul5001Application.class, args);
    }

}
