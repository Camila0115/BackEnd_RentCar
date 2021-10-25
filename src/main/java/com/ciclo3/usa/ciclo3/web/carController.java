package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Carro;
import com.ciclo3.usa.ciclo3.service.carService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Car")
public class carController {

    @Autowired
    private carService CarService;

    @GetMapping("/all")
    public List<Carro> getAll() {
        return CarService.getAllCar();
    }

    @GetMapping("/delete/{id}")
    public Optional<Carro> getId(@PathVariable("id") Integer id) {
        return CarService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Carro Car) {
        CarService.saveCar(Car);
    }
}
