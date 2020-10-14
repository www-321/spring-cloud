package com.cloud.eurekaclientconsumer7001.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicReceiver2 {


    @RabbitHandler
    @RabbitListener(queues = "topic.woman.queue")
    public void receive(@Payload byte[] m, @Header String token) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(m, String.class);
        System.out.println(objectMapper.readValue(m, String.class));
    }

}
