package jdev.server;

import jdev.dto.entity.Point;
import jdev.server.controllers.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

@Configuration
@EnableAsync
@SpringBootApplication
@ComponentScan({"jdev.server.controllers"})
@EntityScan(basePackageClasses = Point.class)
public class ServerCore implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ServerCore.class);
    private List<Point> all;

    public static void main(String[] args) {
        SpringApplication.run(ServerCore.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    private PointRepository pointRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("=========== before create");
        read();

        Point point1 = create("rrrrr");
        Point point2 = create("wwwwww");
        Point point3 = create("ffffff");
        log.info("=========== after create");
        read();

        update(point1, (float) 20.6);
        update(point2, (float) 30.4);
        log.info("=========== after update");
        read();

        delete(point3);
        log.info("=========== after delete point3");
        read();
    }

    private void delete(Point point) {
        pointRepository.delete(point);
    }

    private void update(Point point, Float instantSpeed) {
        point.setInstantSpeed(instantSpeed);
        pointRepository.save(point);
    }


    private void read() {
         all = (List<Point>) pointRepository.findAll();

         if (all.size() == 0) {
             log.info("NO RECORDS");
         }

         all.forEach(point -> log.info(point.toString()));
    }

    private Point create(String autoId) {
        Point point = new Point();
        point.setLat(15.2);
        point.setLon(16.3);
        point.setNowTime();
        point.setAzimuth(152);
        point.setInstantSpeed(36);
        point.setAutoId(autoId);
        return pointRepository.save(point);
    }
}
