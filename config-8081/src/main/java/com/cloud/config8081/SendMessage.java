package com.cloud.config8081;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class SendMessage {


    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("topic", "key", "message");
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(""), exchange = @Exchange(value = "",name = ""))
    }
    )
    public void receive() {

    }

}
