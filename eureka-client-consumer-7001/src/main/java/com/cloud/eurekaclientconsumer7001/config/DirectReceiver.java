package com.cloud.eurekaclientconsumer7001.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DirectReceiver {



    @RabbitHandler
    @RabbitListener(queues = "directQueue")// 当队列已经存在时，直接指定队列名的方式消费
    /**
     * 内部声明了队列，并建立绑定关系
     * value: @Queue 注解，用于声明队列，value 为 queueName, durable 表示队列是否持久化, autoDelete 表示没有消费者之后队列是否自动删除
     * exchange: @Exchange 注解，用于声明 exchange， type 指定消息投递策略，我们这里用的 topic 方式
     * key: 在 topic 方式下，这个就是我们熟知的 routingKey
     */
//    @RabbitListener(
//            bindings = {
//                    @QueueBinding(
//                            value = @Queue(value = "directQueue",durable = "true",autoDelete = "false"),
//                            exchange=@Exchange(value = "directExchange",durable = "true",autoDelete = "false",type = ExchangeTypes.DIRECT),
//                            key = "directKey"
//                    )
//            }
//    )
    public void receive(@Payload byte[] m, @Header String token) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(m, String.class);
        System.out.println(objectMapper.readValue(m, String.class) +"===="+token);
    }


    @RabbitHandler
    @RabbitListener(queues = "directQueue")// 当队列已经存在时，直接指定队列名的方式消费
    /**
     * 内部声明了队列，并建立绑定关系
     * value: @Queue 注解，用于声明队列，value 为 queueName, durable 表示队列是否持久化, autoDelete 表示没有消费者之后队列是否自动删除
     * exchange: @Exchange 注解，用于声明 exchange， type 指定消息投递策略，我们这里用的 topic 方式
     * key: 在 topic 方式下，这个就是我们熟知的 routingKey
     */
//    @RabbitListener(
//            bindings = {
//                    @QueueBinding(
//                            value = @Queue(value = "directQueue",durable = "true",autoDelete = "false"),
//                            exchange=@Exchange(value = "directExchange",durable = "true",autoDelete = "false",type = ExchangeTypes.DIRECT),
//                            key = "directKey"
//                    )
//            }
//    )
    public void receive2(@Payload byte[] m, @Header(value = "header") String header) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(m, String.class);
        System.out.println(objectMapper.readValue(m, String.class) +"===="+header);
    }
}
