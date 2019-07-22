package com.example.sdemo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 09:59
 */

@Data
public class Participant {

    private Long id;

    private Long userId;

    private Long deviceId;

    private Integer isInviter;

    private Integer succeedCount;

    private List<Long> slaveIdList;//活动参与者id与设备id

    private Integer isInvitees;

    private Long masterId;

    private Integer prizeType;

    private Integer prizeDays;

    private Date registerTime;

    public Participant(){}
}
