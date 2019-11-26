package com.example.sdemo.dto;


import lombok.Data;

import java.util.Date;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/30 16:04
 */

@Data
public class ActivityDto {

    private Date startTime;

    private Date endTime;

    private String Message;

    private boolean pass;
}
