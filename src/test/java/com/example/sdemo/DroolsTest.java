package com.example.sdemo;

import com.example.sdemo.dto.ActivityDto;
import com.example.sdemo.entity.Participant;
import com.example.sdemo.service.DroolsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 10:46
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsTest {

    @Autowired
    DroolsService droolsService;

    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,-2);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.MONTH,+4);
        Date endDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Participant participant = new Participant();
        participant.setSucceedCount(1);
        System.out.println(participant.getPrizeDays());
        droolsService.updateParticipant(participant);
        System.out.println(participant.getPrizeDays());

        Participant participant1 = new Participant();
        participant1.setIsNewInvitees(1);
        System.out.println(participant1);
        droolsService.checkParticipant(participant1);
        System.out.println(participant1);

        Participant participant2 = new Participant();
        participant2.setRegisterTime(endDate);
        participant2.setIsNewInvitees(0);
        participant2.setIsNewInviter(0);
        System.out.println(participant2);
        droolsService.checkParticipant(participant2);
        System.out.println(participant2);

        ActivityDto activityDto = new ActivityDto();
        activityDto.setStartTime(startDate);
        activityDto.setEndTime(endDate);
        System.out.println(activityDto);
        droolsService.checkActivityDto(activityDto);
        System.out.println(activityDto);
    }
}
