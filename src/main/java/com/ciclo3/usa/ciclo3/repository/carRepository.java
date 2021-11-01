package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ciclo3.usa.ciclo3.model.Carro;

import java.util.List;
import java.util.Optional;

@Repository
public class carRepository {

    @Autowired
    private carCrudRepository CarCrudRepository;

    public List<Carro> getAllCar() {
        return (List<Carro>) CarCrudRepository.findAll();
    }
    public Optional<Carro> getCar(int id) {
        return CarCrudRepository.findById(id);
    }
    public Carro saveCar(Carro Car) {
        return CarCrudRepository.save(Car);
    }
    public void deleteCar(Carro score){
        CarCrudRepository.delete(score);
    }  
}
