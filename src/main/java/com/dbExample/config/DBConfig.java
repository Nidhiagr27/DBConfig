package com.dbExample.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration   //this shows that it is config class and it creates beans
public class DBConfig {

    @Value("${jdbcUrl}")
    private String jdbcUrl;

    @Value("${dbUsername}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean(destroyMethod = "close")
    @Primary
    DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
