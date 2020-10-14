package com.cloud.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.demo.config.NssaConfig;
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

    @Value("${password}")
    private String password;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("send")
    public void send() {
        rabbitTemplate.convertAndSend("directExchange","directKey", UUID.randomUUID().toString());
    }


    @GetMapping("get/{id}")
    public String cons(@PathVariable String id) throws InterruptedException {
       // Thread.sleep(5000);

        return "from 8763" + id;
    }

    @GetMapping("get/name")
    public String name() {
       return name + nssaConfig.getIp() + nssaConfig.getPort()+"***********"+password;
    }

    @PostMapping(value = "addUser")
    public String add(@RequestBody JSONObject s, HttpServletRequest request) {
        return s.getString("name");
    }
}
