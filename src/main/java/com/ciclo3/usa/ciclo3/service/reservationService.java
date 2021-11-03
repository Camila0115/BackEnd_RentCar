package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Client;
import com.ciclo3.usa.ciclo3.model.ReportClient;
import com.ciclo3.usa.ciclo3.model.ReportStatus;
import com.ciclo3.usa.ciclo3.model.Reservation;
import com.ciclo3.usa.ciclo3.repository.reservationgeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            return ReservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> reservationAux = ReservationRepository.getReservation(reservation.getidReservation());
            if (reservationAux.isEmpty()) {
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

    
    public List<Reservation> ReportReservationsDate(String dateOne, String dateTow) {

        SimpleDateFormat parser = new SimpleDateFormat("yyy-MM-dd");
        Date dateO = new Date();
        Date dateT = new Date();
        try{
            dateO = parser.parse(dateOne);
            dateT = parser.parse(dateTow);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return ReservationRepository.ReportReservationsDate(dateO,dateT);
    }

    public ReportStatus ReportCantState() {
        List<Reservation> completed = ReservationRepository.ReportCantState("completed");
        List<Reservation> cancelled = ReservationRepository.ReportCantState("cancelled");
        ReportStatus respuesta = new ReportStatus(completed.size(),cancelled.size());
        return respuesta;
    }

    public List<ReportClient> ReportClient() {
        List<ReportClient> respuesta = new ArrayList<>(); 
        List<Object[]> reporte = ReservationRepository.ReportClient();
        for(int i=0;i<reporte.size();i++){
            Long total = (Long) reporte.get(i)[0];
            Client cliente = (Client) reporte.get(i)[1];
            ReportClient report = new ReportClient(total,cliente);
            respuesta.add(report);
        }
        return respuesta;
    }
    
}
