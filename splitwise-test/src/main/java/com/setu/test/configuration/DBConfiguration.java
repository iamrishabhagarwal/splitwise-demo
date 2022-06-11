package com.setu.test.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("file:../config/splitwise-test-ms/splitwise-test-ms.properties")
public class DBConfiguration {
	@Autowired
	Environment env;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.splitwise-ms")
	public DataSource secondaryDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.splitwise-ms.driver-class-name"));
		dataSource.setUrl("spring.splitwise-ms.url");
		dataSource.setUsername("spring.splitwise-ms.username");
		dataSource.setPassword("spring.splitwise-ms.password");
		return dataSource;
	}
}
