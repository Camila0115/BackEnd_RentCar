package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Client;

@Repository
public class clientRepository {

    @Autowired
    private clientCrudRepository ClientCrudRepository;

    public List<Client> getAllClient() {
        return (List<Client>) ClientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id) {
        return ClientCrudRepository.findById(id);
    }
    public Client saveClient(Client client) {
        return ClientCrudRepository.save(client);
    }
}
