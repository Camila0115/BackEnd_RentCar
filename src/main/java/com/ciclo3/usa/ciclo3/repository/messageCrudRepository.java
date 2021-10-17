package com.ciclo3.usa.ciclo3.repository;

import com.ciclo3.usa.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface messageCrudRepository extends CrudRepository<Message, Integer> {
  
}

