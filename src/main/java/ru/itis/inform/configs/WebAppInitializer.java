package ru.itis.inform.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.itis.inform.security.TokenAuthenticationFilter;

import javax.servlet.Filter;

/**
 * Created by artur on 14.07.2017.
 */
@Configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{new TokenAuthenticationFilter()};
//    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppContext.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
