package com.cloud.eurekaclientconsumer7001;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients(basePackages = "com.cloud.eurekaclientconsumer7001")
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableRabbit
public class EurekaClientConsumer7001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumer7001Application.class, args);
    }



    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        /*HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(10000);
        factory.setConnectTimeout(20000);*/
        return new RestTemplate();
    }

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }




}
