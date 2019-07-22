package com.example.sdemo.service.impl;

import com.example.sdemo.entity.Participant;
import com.example.sdemo.service.DroolsService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * @program: sdemo
 * @description:
 * @author: yangfan
 * @create: 2019/07/22 10:33
 */

@Service
public class DroolsServiceImpl implements DroolsService {

    @Override
    public Participant updateParticipant(Participant participant) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        try {
            kieSession.insert(participant);
            kieSession.fireAllRules();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            kieSession.dispose();
        }

        return participant;
    }
}
