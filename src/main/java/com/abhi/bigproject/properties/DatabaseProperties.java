package com.abhi.bigproject.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties("datasource")
public class DatabaseProperties {

    private MySqlConfig mysql;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MySqlConfig{
        String driverClassName;
        String jdbcUrl;
        String userName;
        String password;
    }
}
