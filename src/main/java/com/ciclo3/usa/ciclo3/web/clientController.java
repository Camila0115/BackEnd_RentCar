package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Client;
import com.ciclo3.usa.ciclo3.service.clientService;

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
@RequestMapping("/api/Client")
public class clientController {

    @Autowired
    private clientService ClientService;

    @GetMapping("/all")
    public List<Client> getAll() {
        return ClientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Optional<Client> getId(@PathVariable("id") Integer id) {
        return ClientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Client Car) {
        ClientService.saveClient(Car);
    }
}
