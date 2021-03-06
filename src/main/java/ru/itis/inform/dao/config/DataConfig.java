package ru.itis.inform.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Kamil Karimov on 10.07.2017.
 */
@Configuration
@PropertySource("classpath:properties/config.properties")
public class DataConfig {

    @Value("${postgres.username}")
    private String username = "postgres";
    @Value("${postgres.password}")
    private String password = "postgres";
    @Value("${postgres.url}")
    private String url = "jdbc:postgresql://localhost:5432/project";
    @Value("${postgres.driver}")
    private String driver = "org.postgresql.Driver";

    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
