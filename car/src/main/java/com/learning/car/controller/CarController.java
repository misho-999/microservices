package com.learning.car.controller;


import com.learning.car.model.Car;
import com.learning.car.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    private ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity
                .ok()
                .body(carService.findAllCars());
    }

    @GetMapping("/by-user-id/{userId}")
    public ResponseEntity<Car> getCarByUserId(@PathVariable("userId") Integer userId) {
        Car car = carService.findCarByUserId(userId);

        if (car != null) {
            return ResponseEntity
                    .ok()
                    .body(car);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
