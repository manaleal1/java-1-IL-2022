package com.example.java1il2022.week4.day17.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XConfiguration {
    @Bean
    public Object myBean() {
        return new Object();
    }
}
