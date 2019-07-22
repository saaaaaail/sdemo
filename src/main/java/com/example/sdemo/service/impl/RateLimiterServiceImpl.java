package com.example.sdemo.service.impl;

import com.example.sdemo.service.RateLimiterService;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 15:08
 */

@Service
public class RateLimiterServiceImpl implements RateLimiterService {

    @Autowired
    RateLimiter rateLimiter;

    /**
     * 经过测验发现rateLimiter中只会在桶中保留最多qps限制的令牌数目
     * @throws InterruptedException
     */
    @Override
    public void testRateLimiter() throws InterruptedException {
        //RateLimiter rateLimiter = RateLimiter.create(1);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        for (int i=0;i<10;i++){
            int j=i;
            pool.submit(() -> {
                rateLimiter.acquire(1);
                System.out.println(" time: "+(System.currentTimeMillis()-start)+" ms "+Thread.currentThread().getName() + " gets job " + j + " done");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println("all time : "+(System.currentTimeMillis()-start)+" ms ");


    }
}
