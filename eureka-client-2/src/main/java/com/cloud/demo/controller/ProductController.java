package com.cloud.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.demo.config.NssaConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RefreshScope
@RestController
public class ProductController {


    @Autowired
    private NssaConfig nssaConfig;
    @Value("${name}")
    private String name;


    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("send")
    public void send() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] ssses = objectMapper.writeValueAsBytes("sss");
        Message message = MessageBuilder.withBody(ssses)
                .setHeader("token","token123")
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();
        rabbitTemplate.convertAndSend("directExchange","directKey",  message);
    }

    @GetMapping("send_topic")
    public void send1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] ssses = objectMapper.writeValueAsBytes("topic.man.queue");
        Message message = MessageBuilder.withBody(ssses)
                .setHeader("token","token123")
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();
        rabbitTemplate.convertAndSend("topicExchange","topic.man.queue",  message);
    }


    @GetMapping("send_topic2")
    public void send2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] ssses = objectMapper.writeValueAsBytes("topic.woman.queue");
        Message message = MessageBuilder.withBody(ssses)
                .setHeader("token","token123")
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();
        rabbitTemplate.convertAndSend("topicExchange","topic.woman.queue",  message);
    }


    @GetMapping("send_fanout")
    public void send3() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] ssses = objectMapper.writeValueAsBytes("send_fanout");
        Message message = MessageBuilder.withBody(ssses)
                .setHeader("token","token123")
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();
        rabbitTemplate.convertAndSend("fanoutExchange",null,  message);
    }














    @GetMapping("get/{id}")
    public String cons(@PathVariable String id) throws InterruptedException {
       // Thread.sleep(5000);

        return "from 8763" + id;
    }

    @GetMapping("get/name")
    public String name() {
       return name + nssaConfig.getIp() + nssaConfig.getPort()+"***********";
    }

    @PostMapping(value = "addUser")
    public String add(@RequestBody JSONObject s, HttpServletRequest request) {
        return s.getString("name");
    }
}
