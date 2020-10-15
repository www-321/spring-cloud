package com.cloud.prodclient03;

import com.cloud.prodclient03.feign.FeignClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdController {
    @Autowired
    private FeignClientApi feignClientApi;

    @GetMapping("get/{id}")
    public String get(@PathVariable String id) {
        return feignClientApi.getUser(id, "wuquan");
    }
}
