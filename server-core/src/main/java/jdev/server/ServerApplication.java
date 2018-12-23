package jdev.server;

import jdev.dto.Point;
import jdev.dto.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("jdev.dto")
@EntityScan(basePackageClasses = jdev.dto.Point.class)
public class ServerApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);
    private List<Point> all;

    public ServerApplication(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
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

    private void read() {
        all = (List<Point>) pointRepository.findAll();

        if (all.size() == 0) {
            log.info("NO RECORDS");
        }

        all.forEach(point -> log.info(point.toString()));
    }

    private void delete(Point point) {
        pointRepository.delete(point);
    }

    private void update(Point point, Float instantSpeed) {
        point.setInstantSpeed(instantSpeed);
        pointRepository.save(point);
    }

}
