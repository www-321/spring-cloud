package com.cloud.eurekaclientconsumer7001;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients(basePackages = "com.cloud.eurekaclientconsumer7001")
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientConsumer7001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumer7001Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }




}
