package com.cloud.eurekaclientconsumer7001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("get/{id}")
    public String get(@PathVariable String id) {
        return restTemplate.getForObject("http://CLIENT02/get/" + id, String.class);
    }
}
