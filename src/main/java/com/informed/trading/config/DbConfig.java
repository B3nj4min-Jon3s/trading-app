package com.informed.trading.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = {"com.informed.trading.dao"})
@EntityScan(basePackages = {"com.informed.trading.reference"})
@EnableJpaRepositories(basePackages = {"com.informed.trading.repo"})
public class DbConfig {
}
