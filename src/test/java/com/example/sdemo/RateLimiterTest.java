package com.example.sdemo;

import com.example.sdemo.service.RateLimiterService;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 16:03
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RateLimiterTest {

    @Autowired
    RateLimiterService rateLimiterService;

    @Test
    public void test(){
        try {

            rateLimiterService.testRateLimiter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
