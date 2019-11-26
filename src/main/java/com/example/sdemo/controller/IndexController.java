package com.example.sdemo.controller;

import com.example.sdemo.base.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/08/02 14:52
 */

@RestController
public class IndexController {

    @RequestMapping(value = "/health")
    public void health(Result<String> rst){
        rst.setSuccessResult("ok 8081");
    }

    @RequestMapping(value = "/test/ok")
    public void test(Result<String> rst){
        rst.setSuccessResult("test");
    }

    @RequestMapping(value = "/index/ok")
    public void index(Result<String> rst){
        rst.setSuccessResult("index");
    }
}
