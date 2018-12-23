package jdev.tracker;

import jdev.dto.Point;
import jdev.dto.repo.PointRepository;
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
@PropertySource("classpath:/application.properties")
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
    public PointRepository pointRepository() {
        return new PointRepository() {
            @Override
            public <S extends Point> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Point> Iterable<S> save(Iterable<S> entities) {
                return null;
            }

            @Override
            public Point findOne(Integer integer) {
                return null;
            }

            @Override
            public boolean exists(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Point> findAll() {
                return null;
            }

            @Override
            public Iterable<Point> findAll(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void delete(Integer integer) {

            }

            @Override
            public void delete(Point entity) {

            }

            @Override
            public void delete(Iterable<? extends Point> entities) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

}
