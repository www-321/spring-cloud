package com.cloud.nacos.controller;

import com.cloud.nacos.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private FeignService feignService;


    @GetMapping("index")
    public String get() {
        return feignService.get();
    }


    @GetMapping("port")
    public String get1() {
        return port;
    }

}
