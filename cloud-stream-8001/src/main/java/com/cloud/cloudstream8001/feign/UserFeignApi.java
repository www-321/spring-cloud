package com.cloud.cloudstream8001.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(value = "CLIENT02",configuration = FeignConfig.class, fallback = UserFeignApiFallback.class)
@FeignClient(value = "CLIENT-PRODUCT")
public interface UserFeignApi {

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") String id, @RequestParam("name") String name);


    @RequestMapping(value = "/addUser",method =RequestMethod.POST,consumes = "application/json")
    public String postUser(@RequestBody String s);

}
