package jdev.tracker.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String... args) {

        ApplicationContext gps = new AnnotationConfigApplicationContext(GPSContext.class);

    }
}
