package jdev.tracker;

import jdev.dto.entity.Point;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@SpringBootApplication
@ComponentScan({"jdev.tracker.services"})
@EntityScan(basePackageClasses = Point.class)
@PropertySource("classpath:/application.properties")
public class Main {

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
        ApplicationContext gps = new AnnotationConfigApplicationContext(GPSContext.class);
    }

}
