package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.ReportStatus;
import com.ciclo3.usa.ciclo3.model.ReportClient;
import com.ciclo3.usa.ciclo3.model.Reservation;
import com.ciclo3.usa.ciclo3.service.reservationService;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class reservationController {

    @Autowired
    private reservationService ReservationService;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return ReservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getId(@PathVariable("id") Integer id) {
        return ReservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Reservation reservacion) {
        ReservationService.saveReservation(reservacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Reservation reservacion){
        ReservationService.update(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int idreservacion) {
        return ReservationService.deleteReservation(idreservacion);
    }

    //Reto 5

    @GetMapping("/report-dates/{dateOne}/{datetwo}")
    public List<Reservation> ReportReservationsDate(@PathVariable("dateOne") String DateOne,@PathVariable("datetwo") String DateTwo) {
        return ReservationService.ReportReservationsDate(DateOne,DateTwo);
    }

    @GetMapping("/report-status")
    public ReportStatus ReportCantState() {
        return ReservationService.ReportCantState();
    }

    @GetMapping("/report-clients")
    public List<ReportClient> ReportClient() {
        return ReservationService.ReportClient();
    }
    
}
