package com.cloud.eurekaclientconsumer7001.config;

import com.cloud.eurekaclientconsumer7001.feign.UserFeignApi;
import org.springframework.stereotype.Component;

/**
 * 降级方法
 */
@Component
public class UserFeignApiFallback implements UserFeignApi {
    @Override
    public String getUser(String id, String name) {
        return "fallback user";
    }

    @Override
    public String postUser(String s) {
        return "fallback success";
    }
}
