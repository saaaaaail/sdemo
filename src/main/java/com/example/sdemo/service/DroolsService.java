package com.example.sdemo.service;

import com.example.sdemo.dto.ActivityDto;
import com.example.sdemo.entity.Participant;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 10:28
 */


public interface DroolsService {

    Participant updateParticipant(Participant participant);

    Participant checkParticipant(Participant participant);

    ActivityDto checkActivityDto(ActivityDto activityDto);

}
