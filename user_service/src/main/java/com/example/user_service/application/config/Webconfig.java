package com.example.user_service.application.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Webconfig {
    @LoadBalanced
    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }
}
