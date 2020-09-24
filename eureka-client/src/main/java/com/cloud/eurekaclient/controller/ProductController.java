package com.cloud.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @GetMapping("get/{id}")
    public String cons(@PathVariable String id) {
        return "from 8761" + id;
    }
}
