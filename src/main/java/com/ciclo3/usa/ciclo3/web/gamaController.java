package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Gama;
import com.ciclo3.usa.ciclo3.service.gamaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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
    public void save(@RequestBody Gama gama) {
        GamaService.saveGama(gama);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Gama gama){
        GamaService.update(gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Gama> delete(@PathVariable ("id") int digama) {
        GamaService.deleteClient(digama);
        return GamaService.getAllGama();
    }
}
