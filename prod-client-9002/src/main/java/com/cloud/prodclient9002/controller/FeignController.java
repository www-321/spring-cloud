package com.cloud.prodclient9002.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {




    @GetMapping("/get/{id}")
    public String get(@PathVariable String id) {
        return id +"   prod-02";
    }
}
