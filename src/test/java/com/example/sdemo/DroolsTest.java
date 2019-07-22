package com.example.sdemo;

import com.example.sdemo.entity.Participant;
import com.example.sdemo.service.DroolsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Participant participant = new Participant();
        participant.setIsInvitees(1);
        System.out.println(participant.getPrizeDays());
        droolsService.updateParticipant(participant);
        System.out.println(participant.getPrizeDays());
    }
}
