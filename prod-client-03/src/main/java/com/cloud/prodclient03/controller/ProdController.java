package com.cloud.prodclient03.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.prodclient03.feign.FeignClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.security.x509.NameConstraintsExtension;

@RestController
public class ProdController {
    @Autowired
    private FeignClientApi feignClientApi;

    @GetMapping("get/{id}")
    public String get(@PathVariable String id) {
        return feignClientApi.getUser(id, "wuquan");
    }


    @GetMapping("/prod3/get_user")
    public JSONObject getUser(String name, String age) {
        JSONObject o = new JSONObject();
        o.put("name", name);
        o.put("age", age);
        return o;
    }


    @GetMapping("/prod3/del_user")
    public JSONObject delUser(String name, String age) {
        JSONObject o = new JSONObject();
        o.put("del", true);
        return o;
    }
}
