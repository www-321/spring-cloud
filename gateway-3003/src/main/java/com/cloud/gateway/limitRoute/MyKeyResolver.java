package com.cloud.gateway.limitRoute;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class MyKeyResolver {


    //IP限流
    @Bean(name = "hostAddrKeyResolver")
    public KeyResolver hostAddrKeyResolver() {
         return exchange -> Mono.just( exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    //uri限流
    @Bean(name = "uriKeyResolver")
    public KeyResolver uriKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }






}
