package ru.itis.inform.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.itis.inform.security.PermissionEntryPoint;
import ru.itis.inform.security.TokenAuthenticationEntryPoint;
import ru.itis.inform.security.TokenAuthenticationFilter;
import ru.itis.inform.security.user.UserDetailsServiceImpl;

import javax.servlet.Filter;

/**
 * Created by Yoko on 16.07.2017.
 */
@Configuration
@EnableWebSecurity
@ComponentScan("ru.itis.inform")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests().anyRequest().permitAll();
    }

    @Bean
    public TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint() {
        return new TokenAuthenticationEntryPoint();
    }

    @Bean
    public PermissionEntryPoint permissionEntryPoint() {
        return new PermissionEntryPoint();
    }

    @Bean
    public Filter tokenAuthenticationFilter(UserDetailsService userDetailsService) {
        return new TokenAuthenticationFilter(userDetailsService);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
