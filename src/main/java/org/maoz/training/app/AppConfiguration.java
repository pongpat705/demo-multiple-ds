package org.maoz.training.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Value("${app.datasource1.url}")
    private String dbUrl;
    @Value("${app.datasource1.username}")
    private String dbUserName;
    @Value("${app.datasource1.password}")
    private String dbPassword;
    @Value("${app.datasource1.driver}")
    private String dbDriver;


    @Bean("myDs")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dbDriver);
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(dbUserName);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }
}
