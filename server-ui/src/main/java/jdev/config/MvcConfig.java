package jdev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("sec_main");
        registry.addViewController("/login").setViewName("sec_login");
        registry.addViewController("/routes").setViewName("sec_routes");
        registry.addViewController("/payments").setViewName("sec_payments");
        registry.addViewController("/registerClient").setViewName("sec_register_client");
        registry.addViewController("/registerManager").setViewName("sec_register_manager");
        registry.addViewController("/home").setViewName("sec_home");
        registry.addViewController("/error");
    }

}
