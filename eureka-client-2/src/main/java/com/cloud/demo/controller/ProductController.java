package com.cloud.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.demo.config.NssaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProductController {


    @Autowired
    private NssaConfig nssaConfig;
    @Value("${name}")
    private String name;

    @GetMapping("get/{id}")
    public String cons(@PathVariable String id) throws InterruptedException {
       // Thread.sleep(5000);

        return "from 8763" + id;
    }

    @GetMapping("get/name")
    public String name() {
       return name + nssaConfig.getIp() + nssaConfig.getPort();
    }

    @PostMapping(value = "addUser")
    public String add(@RequestBody JSONObject s, HttpServletRequest request) {
        return s.getString("name");
    }
}
