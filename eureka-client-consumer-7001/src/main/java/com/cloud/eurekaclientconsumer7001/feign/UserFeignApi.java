package com.cloud.eurekaclientconsumer7001.feign;

import com.cloud.eurekaclientconsumer7001.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "CLIENT02",configuration = FeignConfig.class)
public interface UserFeignApi {

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") String id, @RequestParam("name") String name);


    @RequestMapping(value = "/addUser",method =RequestMethod.POST,consumes = "application/json")
    public String postUser(@RequestBody String s);

}
