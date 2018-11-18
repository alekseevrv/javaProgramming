package jdev.tracker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String... args) {
        ApplicationContext gps = new AnnotationConfigApplicationContext(GPSContext.class);
    }

}
