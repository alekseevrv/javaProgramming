package jdev.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled (fixedDelay = 3000)
    private void tick() {
        System.out.println("ScheduledService.tick");
    }
}
