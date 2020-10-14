package com.cloud.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {


    @Bean
    public Queue directQueue() {
        return new Queue("directQueue");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange", true, false);
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("directKey");
    }
}
