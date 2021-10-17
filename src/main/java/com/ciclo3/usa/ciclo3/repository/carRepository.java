package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ciclo3.usa.ciclo3.model.car;

import java.util.List;
import java.util.Optional;

@Repository
public class carRepository {

    @Autowired
    private carCrudRepository CarCrudRepository;

    public List<car> getAllCar() {
        return (List<car>) CarCrudRepository.findAll();
    }
    public Optional<car> getCar(int id) {
        return CarCrudRepository.findById(id);
    }
    public car saveCar(car Car) {
        return CarCrudRepository.save(Car);
    }
}
