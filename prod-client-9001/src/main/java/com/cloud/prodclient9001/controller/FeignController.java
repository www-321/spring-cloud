package com.cloud.prodclient9001.controller;

import com.cloud.prodclient9001.feign.ProdClient01FeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
public class FeignController {

    @Autowired
    private ProdClient01FeignApi prodClient01FeignApi;

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id, String name) {
        return prodClient01FeignApi.getUser(id);
    }

    @GetMapping("/get")
    public String get1( ) {
        return "client 9001";
    }

    @GetMapping("/client1/get")
    public String ge2t1( ) {
        return "client1  get 9001  ";
    }

}
