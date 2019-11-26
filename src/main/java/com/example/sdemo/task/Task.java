package com.example.sdemo.task;

import com.example.sdemo.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/26 18:38
 */

public class Task {



    ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);





    public static void main(String[] args) {
        Task task = new Task();
    }

}
