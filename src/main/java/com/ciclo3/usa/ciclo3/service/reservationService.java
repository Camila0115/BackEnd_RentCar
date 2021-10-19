package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Reservation;
import com.ciclo3.usa.ciclo3.repository.reservationgeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reservationService {

    @Autowired
    private reservationgeRepository ReservationRepository;

    public List<Reservation> getAllReservation() {
        return (List<Reservation>) ReservationRepository.getAllReservation();
    }

    public Optional<Reservation> getReservation(int id) {
        return ReservationRepository.getReservation(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getidReservation() == null) {
            reservation.setstatus("created");
            reservation.setscore("None");
            String startDate = reservation.getstartDate() + "T00:00:00.000+00:00";
            String devolutionDate = reservation.getdevolutionDate() + "T00:00:00.000+00:00";
            reservation.setstartDate(startDate);
            reservation.setdevolutionDate(devolutionDate);
            return ReservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> reservationAux = ReservationRepository.getReservation(reservation.getidReservation());
            if (reservationAux.isEmpty()) {
                reservation.setstatus("created");
                reservation.setscore("None");
                String startDate = reservation.getstartDate() + "T00:00:00.000+00:00";
                String devolutionDate = reservation.getdevolutionDate() + "T00:00:00.000+00:00";
                reservation.setstartDate(startDate);
                reservation.setdevolutionDate(devolutionDate);
                return ReservationRepository.saveReservation(reservation);
            } else {
                return reservation;
            }
        }

    }
}
