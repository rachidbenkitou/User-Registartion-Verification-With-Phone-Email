package com.bokito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//exclude = {DataSourceAutoConfiguration.class}
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) // on a dit a spring de ne configure pas datasource.
public class SaadiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaadiApplication.class, args);
    }
}
