package com.cloud.prodclient9001.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(value = "CLIENT02",configuration = FeignConfig.class, fallback = UserFeignApiFallback.class)
@FeignClient(value = "PROD-CLIENT-02")
public interface ProdClient01FeignApi {

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") String id);


}
