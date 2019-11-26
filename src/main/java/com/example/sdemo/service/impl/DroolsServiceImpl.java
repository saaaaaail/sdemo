package com.example.sdemo.service.impl;

import com.example.sdemo.dto.ActivityDto;
import com.example.sdemo.entity.Participant;
import com.example.sdemo.service.DroolsService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 10:33
 */

@Service
public class DroolsServiceImpl implements DroolsService {

    @Cacheable(value = "participantInfo")
    @Override
    public Participant updateParticipant(Participant participant) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("ksession-prize");

        kieSession.execute(participant);
        return participant;
    }

    @Override
    public Participant checkParticipant(Participant participant) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("ksession-admission");

        kieSession.execute(participant);
        return participant;
    }

    @Override
    public ActivityDto checkActivityDto(ActivityDto activityDto) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("ksession-activity");

        kieSession.execute(activityDto);
        return activityDto;
    }
}
