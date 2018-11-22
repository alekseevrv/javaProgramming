package jdev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/static/**").permitAll()
                .antMatchers("/routes/**", "/payments/**").hasRole("CLIENT")
                .antMatchers("/registerClient/**").hasRole("MANAGER")
                .antMatchers("/registerManager/**").hasRole("ROOT")
                .antMatchers("/error", "/home").authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("client").password("123").roles("CLIENT")
                .and()
                .withUser("manager").password("123").roles("MANAGER", "CLIENT")
                .and()
                .withUser("root").password("123").roles("ROOT", "MANAGER", "CLIENT");
    }
}
