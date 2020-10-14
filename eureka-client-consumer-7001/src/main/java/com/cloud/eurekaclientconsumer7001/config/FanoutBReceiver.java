package com.cloud.eurekaclientconsumer7001.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FanoutBReceiver {


    @RabbitHandler
    @RabbitListener(queues = "fanout.B")// 当队列已经存在时，直接指定队列名的方式消费
    public void receive(@Payload byte[] m, @Header String token) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(m, String.class);
        System.out.println(objectMapper.readValue(m, String.class)+"B");
    }

}
