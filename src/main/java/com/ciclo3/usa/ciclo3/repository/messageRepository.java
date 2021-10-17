package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Message;

@Repository
public class messageRepository {

    @Autowired
    private messageCrudRepository MessageCrudRepository;

    public List<Message> getAllMessage() {
        return (List<Message>) MessageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id) {
        return MessageCrudRepository.findById(id);
    }
    public Message saveMessage(Message message) {
        return MessageCrudRepository.save(message);
    }
}
