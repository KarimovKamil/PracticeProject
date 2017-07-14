package ru.itis.inform.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by artur on 14.07.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.itis.inform")
public class WebAppContext extends WebMvcConfigurerAdapter {
}