package jdev.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    private int count;

    @Scheduled(cron = "*/4 * * * * *")
    private void tick() {
        System.out.println("ScheduledService.tick " + count++);
    }
}
