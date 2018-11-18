package jdev.tracker;

import jdev.tracker.services.GPSMessageStorageService;
import jdev.tracker.services.GPSMessagingService;
import jdev.tracker.services.GPSService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class GPSContext {

    @Bean
    public GPSService gpsService() {
        return new GPSService();
    }

    @Bean
    public GPSMessageStorageService GPSMessageStorageService() {
        return new GPSMessageStorageService();
    }

    @Bean
    public GPSMessagingService GPSMessagingService() {
        return new GPSMessagingService();
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }

}
