package com.learning.car.service.impl;


import com.learning.car.model.Car;
import com.learning.car.repository.CarRepository;
import com.learning.car.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car findCarByUserId(Integer userId) {
        return carRepository.findByUserId(userId).orElseGet(null);
    }
}
