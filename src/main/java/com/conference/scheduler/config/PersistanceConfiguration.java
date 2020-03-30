package com.conference.scheduler.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfiguration {
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/pluralsight");
        dataSourceBuilder.password("asdf");
        dataSourceBuilder.username("postgres");
        return dataSourceBuilder.build();
    }
}
