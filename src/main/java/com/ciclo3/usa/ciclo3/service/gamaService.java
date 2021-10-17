package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Gama;
import com.ciclo3.usa.ciclo3.repository.gamaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class gamaService {
    
    @Autowired
    private gamaRepository GamaRepository;

    public List<Gama> getAllGama() {
        return (List<Gama>) GamaRepository.getAllGama();
    }
    public Optional<Gama> getGama(int id) {
        return GamaRepository.getGama(id);
    }
    public Gama saveGama(Gama gama) {
        if(gama.getidGama() == null){
            return GamaRepository.saveGama(gama);
        }
        else{
            Optional<Gama> gamaAux = GamaRepository.getGama(gama.getidGama());
            if(gamaAux.isEmpty()){
                return GamaRepository.saveGama(gama); 
            }else{
                return gama;
            }
        }
        
    }
}
