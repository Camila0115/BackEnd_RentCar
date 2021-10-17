package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Gama;
import com.ciclo3.usa.ciclo3.service.gamaService;

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
@RequestMapping("/api/Gama")
public class gamaController {

    @Autowired
    private gamaService GamaService;

    @GetMapping("/all")
    public List<Gama> getAll() {
        return GamaService.getAllGama();
    }

    @GetMapping("/{id}")
    public Optional<Gama> getId(@PathVariable("id") Integer id) {
        return GamaService.getGama(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama Car) {
        return GamaService.saveGama(Car);
    }
}