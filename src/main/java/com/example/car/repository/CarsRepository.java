package com.example.car.repository;

import com.example.car.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepository extends CrudRepository<Car, Long> {
}
