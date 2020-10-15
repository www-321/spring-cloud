package com.cloud.prodclient03.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.DocFlavor;

@FeignClient(value = "PROD-CLIENT-01")
public interface FeignClientApi {



    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") String id, @RequestParam String name);

}
