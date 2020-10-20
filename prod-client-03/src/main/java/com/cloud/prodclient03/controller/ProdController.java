package com.cloud.prodclient03.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.prodclient03.feign.FeignClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.security.x509.NameConstraintsExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    @GetMapping("admin")
    public String admin() {

        return "admin";
    }

    @GetMapping("/prod3/del_user")
    public JSONObject delUser(String name, String age) {
        JSONObject o = new JSONObject();
        o.put("del", true);
        return o;
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date s = sdf.parse("2020-04-04");
        Calendar instance = Calendar.getInstance();
        instance.setTime(s);
        instance.add(Calendar.DAY_OF_YEAR, 200);
        System.out.println(instance.getTime());
    }
}
