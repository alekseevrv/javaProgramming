package jdev.tracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("jdev.dto")
@EntityScan(basePackageClasses = jdev.dto.Point.class)
public class TrackerApplication implements CommandLineRunner {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String... args) {
        SpringApplication.run(TrackerApplication.class, args);

        ApplicationContext gps = new AnnotationConfigApplicationContext(GPSContext.class);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
