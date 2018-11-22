package jdev.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("jdev.config")
public class Security {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Security.class, args);
    }

}
