package com.abhi.bigproject.config;

import com.abhi.bigproject.constants.ApplicationConstants;
import com.abhi.bigproject.properties.DatabaseProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DataSourceConfig {

    DatabaseProperties databaseProperties;

    @Autowired
    public DataSourceConfig(DatabaseProperties databaseProperties){
        this.databaseProperties = databaseProperties;
    }
    @Bean
    @Profile(ApplicationConstants.MYSQL_PROFILE)
    public DataSource dataSourceMysql(){
        HikariDataSource dataSource=new HikariDataSource();
        log.info("Connecting to the MySql Database.");
        dataSource.setDriverClassName(databaseProperties.getMysql().getDriverClassName());
        dataSource.setJdbcUrl(databaseProperties.getMysql().getJdbcUrl());
        dataSource.setUsername(databaseProperties.getMysql().getUserName());
        dataSource.setPassword(databaseProperties.getMysql().getPassword());

        return dataSource;
    }
}
