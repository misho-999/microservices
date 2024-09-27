package com.learning.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarServiceImpl {
    public static final String CAR_SERVICE_URI = "http://car-api";

    private final RestTemplate restTemplate;

    public CarServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    public String getCarByUserId(Integer userId){
//        restTemplate.getForEntity(CAR_SERVICE_URI + "cars/all");
//    }
}
