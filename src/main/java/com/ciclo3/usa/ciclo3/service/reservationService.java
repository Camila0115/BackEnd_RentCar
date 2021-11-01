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
            String startDate = reservation.getstartDate() + "T00:00:00.000+00:00";
            String devolutionDate = reservation.getdevolutionDate() + "T00:00:00.000+00:00";
            reservation.setstartDate(startDate);
            reservation.setdevolutionDate(devolutionDate);
            return ReservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> reservationAux = ReservationRepository.getReservation(reservation.getidReservation());
            if (reservationAux.isEmpty()) {
                reservation.setstatus("created");
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

    public Reservation update(Reservation reservacion) {
        if (reservacion.getidReservation() != null) {
            Optional<Reservation> mensajetAux = ReservationRepository.getReservation(reservacion.getidReservation());
            if (reservacion.getstartDate() != null) {
                mensajetAux.get().setstartDate(reservacion.getstartDate());
            }
            if (reservacion.getdevolutionDate() != null) {
                mensajetAux.get().setdevolutionDate(reservacion.getdevolutionDate());
            }
            if (reservacion.getclient() != null) {
                mensajetAux.get().setclient(reservacion.getclient());
            }
            if (reservacion.getcar() != null) {
                mensajetAux.get().setcar(reservacion.getcar());
            }
            return ReservationRepository.saveReservation(mensajetAux.get());
        }
        return reservacion;
    }

    public boolean deleteReservation(int IdMensaje) {
        Boolean aBoolean = getReservation(IdMensaje).map(reservation ->{
            ReservationRepository.deleteReservation(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
