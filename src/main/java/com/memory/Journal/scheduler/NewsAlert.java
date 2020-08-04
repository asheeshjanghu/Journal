package com.memory.Journal.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NewsAlert {

    @Scheduled(fixedRate = 1000L)
    public void sendNewsAlerts() {
        System.out.println("Sent email.");
    }
}
