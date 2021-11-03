package com.ciclo3.usa.ciclo3.repository;

import java.util.Date;
import java.util.List;

import com.ciclo3.usa.ciclo3.model.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface reservationCrudRepository extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTow);

    public List<Reservation> findAllByStatus(String estado);

    @Query("select COUNT(c.status) AS total, c.client from Reservation AS c group by c.client order by COUNT(c.status)")
    public List<Object[]> countClientsReport();
}