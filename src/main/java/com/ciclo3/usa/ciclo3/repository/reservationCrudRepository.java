package com.ciclo3.usa.ciclo3.repository;

import com.ciclo3.usa.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface reservationCrudRepository extends CrudRepository<Reservation, Integer> {
  
}

