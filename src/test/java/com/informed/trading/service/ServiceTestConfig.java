package com.informed.trading.service;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
@PropertySource("classpath:TestConfig.properties") //classpath:jdbc.TestConfig.properties.properties
@ComponentScan(basePackages = {
        "com.informed.trading.dao",
        "com.informed.trading.service",
        "com.informed.trading.controller",
        "com.informed.trading.config.exchange"})
@EntityScan(basePackages = {"com.informed.trading.reference"})
@EnableJpaRepositories(basePackages = {"com.informed.trading.repo"})
public class ServiceTestConfig {
}
