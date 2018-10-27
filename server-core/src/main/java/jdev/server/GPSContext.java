package jdev.server;

import jdev.server.services.GPSMessageStorageService;
import jdev.server.services.GPSMessagingService;
import jdev.server.services.GPSService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

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

}
