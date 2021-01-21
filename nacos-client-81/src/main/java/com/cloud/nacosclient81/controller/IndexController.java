package com.cloud.nacosclient81.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @GetMapping("index")
    public String get() {
        return "81";
    }
}
