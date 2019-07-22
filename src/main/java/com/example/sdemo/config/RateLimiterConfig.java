package com.example.sdemo.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 15:49
 */

@Configuration
public class RateLimiterConfig {

    @Bean
    public RateLimiter rateLimiter(){
        return RateLimiter.create(2);
    }
}
