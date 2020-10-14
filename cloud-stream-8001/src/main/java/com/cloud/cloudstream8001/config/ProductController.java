package com.cloud.cloudstream8001.config;

import com.cloud.cloudstream8001.feign.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @Autowired
    private UserFeignApi  userFeignApi;

    @GetMapping("get/{id}")
    public String cons(@PathVariable String id) {
        return userFeignApi.getUser(id, "wuquan");
    }
}
