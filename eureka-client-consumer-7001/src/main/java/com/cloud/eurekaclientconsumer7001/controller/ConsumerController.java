package com.cloud.eurekaclientconsumer7001.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.eurekaclientconsumer7001.feign.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {



    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    UserFeignApi userFeignApi;


    @GetMapping("get/{id}")
    public String get(@PathVariable String id) {

        int i =1/0;
        return userFeignApi.getUser(id,"wuquan");
    }

    @PostMapping(value = "add",consumes = "application/json")
    public Object addd() {

        JSONObject o = new JSONObject();
        o.put("name", "wuquan");
        String s = JSON.toJSONString(o);
        Object o1 = userFeignApi.postUser(s);
        System.out.println(o1);
        return o1;
    }
}
