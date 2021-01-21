package com.cloud.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-81")
public interface FeignService {

    @GetMapping("index")
    public String get();
}
