package com.cloud.eurekaclientconsumer7001.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.eurekaclientconsumer7001.feign.UserFeignApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;
    //@Qualifier("")
    @Autowired
    UserFeignApi userFeignApi;


    @HystrixCommand(fallbackMethod = "fallback1",commandProperties = {
        //@HystrixProperty(name = "", value = ""), @HystrixProperty(name = "", value = "")
    })
    @GetMapping("get/{id}")
    public Object get(@PathVariable Integer id) throws InterruptedException {
        //1，异常情况
        int i = id / (id - 2);
        //2，超时熔断
        //Thread.sleep(100000);
        return userFeignApi.getUser(id+"", "wuquan");
    }

    private Object fallback1(Integer id){
        JSONObject o = new JSONObject();
        o.put("11", id);
        return o;
    }


    @PostMapping(value = "add", consumes = "application/json")
    public Object addd() {

        JSONObject o = new JSONObject();
        o.put("name", "wuquan");
        String s = JSON.toJSONString(o);
        Object o1 = userFeignApi.postUser(s);
        System.out.println(o1);
        return o1;
    }
}
