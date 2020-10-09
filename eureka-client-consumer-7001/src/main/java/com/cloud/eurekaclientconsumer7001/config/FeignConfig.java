package com.cloud.eurekaclientconsumer7001.config;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


public class FeignConfig {


    /**
     * 此feign实例，不走熔断
     * @return
     */
    //@Bean
//    @Scope("prototype")
    public Feign.Builder builder() {
        return Feign.builder();
    }


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
    //@Bean
    public Request.Options options() {
        return new Request.Options(3000, 5000);
    }



}
