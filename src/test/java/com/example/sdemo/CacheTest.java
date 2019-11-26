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
 * @create: 2019/07/22 17:49
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {

    @Autowired
    DroolsService droolsService;

    @Test
    public void Test(){
        Participant participant = new Participant();
        participant.setSucceedCount(3);
        droolsService.updateParticipant(participant);
    }
}
