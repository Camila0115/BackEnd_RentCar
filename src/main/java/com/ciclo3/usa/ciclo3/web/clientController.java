package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Client;
import com.ciclo3.usa.ciclo3.service.clientService;

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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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
    public void save(@RequestBody Client client) {
        ClientService.saveClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Client client){
        ClientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Client> delete(@PathVariable ("id") int idclient) {
         ClientService.deleteClient(idclient);
         return ClientService.getAllClient();
    }
}
