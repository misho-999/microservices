package com.learning.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
       return new RestTemplate();
    }
}
