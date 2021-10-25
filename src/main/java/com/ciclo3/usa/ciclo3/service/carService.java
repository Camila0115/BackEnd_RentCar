package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Carro;
import com.ciclo3.usa.ciclo3.repository.carRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class carService {
    
    @Autowired
    private carRepository CarRepository;

    public List<Carro> getAllCar() {
        return (List<Carro>) CarRepository.getAllCar();
    }
    public Optional<Carro> getCar(int id) {
        return CarRepository.getCar(id);
    }
    public Carro saveCar(Carro Car) {
        if(Car.getidCar() == null){
            return CarRepository.saveCar(Car);
        }
        else{
            Optional<Carro> CarAux = CarRepository.getCar(Car.getidCar());
            if(CarAux.isEmpty()){
                return CarRepository.saveCar(Car); 
            }else{
                return Car;
            }
        }
        
    }
}
