package com.example.sdemo.controller;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/23 09:13
 */

import com.example.sdemo.base.Result;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RateLimitController {

    @Autowired
    public RateLimiter rateLimiter;

    /**
     * 需要10个令牌
     * @param rst
     */
    @RequestMapping(value = "ratelimit",method = RequestMethod.GET)
    public void visit(Result<String> rst){
        rateLimiter.acquire(10);
        rst.setSuccessResult(HttpStatus.OK.value(),"limit");
    }

    public static void main(String[] args) {
        Set<String> setA = new HashSet<>();
        setA.add("a");
        setA.add("b");

        Set<String> setB = new HashSet<>();
        setB.add("d");
        setB.add("e");
        setB.add("c");
        setA.retainAll(setB);
        System.out.println(setA);

    }
}
