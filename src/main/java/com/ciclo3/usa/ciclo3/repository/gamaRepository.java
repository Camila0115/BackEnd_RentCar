package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclo3.usa.ciclo3.model.Gama;

import java.util.List;
import java.util.Optional;

@Repository
public class gamaRepository {

    @Autowired
    private gamaCrudRepository GamaCrudRepository;

    public List<Gama> getAllGama() {
        return (List<Gama>) GamaCrudRepository.findAll();
    }
    public Optional<Gama> getGama(int id) {
        return GamaCrudRepository.findById(id);
    }
    public Gama saveGama(Gama gama) {
        return GamaCrudRepository.save(gama);
    }
}
