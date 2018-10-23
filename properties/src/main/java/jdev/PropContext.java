package jdev;

import jdev.services.InjectedService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/app.properties")
public class PropContext {

    @Bean
    public InjectedService injectedService() {
        return new InjectedService();
    }
}
