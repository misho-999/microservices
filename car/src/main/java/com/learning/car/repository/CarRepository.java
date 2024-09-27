package com.learning.car.repository;

import com.learning.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

   Optional<Car> findByUserId(Integer userId);
}
