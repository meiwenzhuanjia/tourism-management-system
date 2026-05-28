package com.trip.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.trip.dao.mapper")
@ComponentScan(basePackages = {"com.trip.api", "com.trip.service"})
@SpringBootApplication
public class ScenicApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScenicApiApplication.class, args);
    }
}
