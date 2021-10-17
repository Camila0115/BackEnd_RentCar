package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.car;
import com.ciclo3.usa.ciclo3.repository.carRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class carService {
    
    @Autowired
    private carRepository CarRepository;

    public List<car> getAllCar() {
        return (List<car>) CarRepository.getAllCar();
    }
    public Optional<car> getCar(int id) {
        return CarRepository.getCar(id);
    }
    public car saveCar(car Car) {
        if(Car.getId() == null){
            return CarRepository.saveCar(Car);
        }
        else{
            Optional<car> CarAux = CarRepository.getCar(Car.getId());
            if(CarAux.isEmpty()){
                return CarRepository.saveCar(Car); 
            }else{
                return Car;
            }
        }
        
    }
}
