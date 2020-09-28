package com.cloud.eurekaclientconsumer7001.feign;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class FeignConfig {


    //日志
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignIntercepter();
    }

    //请求超时时间
    @Bean
    public Request.Options options() {
        return new Request.Options(3000, 5000);
    }

}
