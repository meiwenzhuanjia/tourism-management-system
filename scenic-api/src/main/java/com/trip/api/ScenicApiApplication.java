package com.trip.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.trip")
@SpringBootApplication
public class ScenicApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScenicApiApplication.class, args);
    }
}
