package com.cloud.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProductController {


    @GetMapping("get/{id}")
    public String cons(@PathVariable String id) {
        return "from 8763" + id;
    }

    @PostMapping(value = "addUser")
    public String add(@RequestBody JSONObject s, HttpServletRequest request) {
        return s.getString("name");
    }
}
