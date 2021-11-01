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
        if (Car.getidCar() == null) {
            return CarRepository.saveCar(Car);
        } else {
            Optional<Carro> CarAux = CarRepository.getCar(Car.getidCar());
            if (CarAux.isEmpty()) {
                return CarRepository.saveCar(Car);
            } else {
                return Car;
            }
        }

    }

    public Carro update(Carro Car) {
        if (Car.getidCar() != null) {
            Optional<Carro> CarAux = CarRepository.getCar(Car.getidCar());
            if (Car.getname() != null) {
                CarAux.get().setname(Car.getname());
            }
            if (Car.getbrand() != null) {
                CarAux.get().setbrand(Car.getbrand());
            }
            if (Car.getyear() != null) {
                CarAux.get().setyear(Car.getyear());
            }
            if (Car.getdescription() != null) {
                CarAux.get().setdescription(Car.getdescription());
            }
            if (Car.getgama() != null) {
                CarAux.get().setgama(Car.getgama());
            }
            return CarRepository.saveCar(CarAux.get());
        }
        return Car;
    }

    public boolean deleteCar (int IdCar) {
        Boolean aBoolean = getCar(IdCar).map(car ->{
            CarRepository.deleteCar(car);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
