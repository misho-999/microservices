package com.learning.user.service.impl;

import com.learning.user.model.Car;
import com.learning.user.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarServiceImpl implements CarService {
    public static final String CAR_SERVICE_URI = "http://car-service";

    private final RestTemplate restTemplate;

    public CarServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Car getCarByUserId(Integer userId) {
        ResponseEntity<Car> response = restTemplate.getForEntity(CAR_SERVICE_URI + "/cars/by-user-id/{userId}", Car.class, userId);

        return response.getBody();
    }
}
