package jdev.tracker;

import jdev.dto.entity.Point;
import jdev.tracker.services.GPSMessageStorageService;
import jdev.tracker.services.GPSMessagingService;
import jdev.tracker.services.GPSService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
@EntityScan(basePackageClasses = Point.class)
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

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
