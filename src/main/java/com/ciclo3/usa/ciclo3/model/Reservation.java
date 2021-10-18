package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties("reservation")
    car car;
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservation"})
    Client client;
    
    private Integer score;
   

    //se estable el get set de id
    public Integer getidReservation() {
        return idReservation;
    }
    public void setidReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    //se estable el get set de fechaInicio
    public Date getstartDate() {
        return startDate;
    }
    public void setstartDate(Date startDate) {
        this.startDate = startDate;
    }

    //se estable el get set de fechaEntrega
    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }

    //se estable el get set de status
    public Date getdevolutionDate() {
        return devolutionDate;
    }
    public void setdevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    
    //se estable el get set  del carro asociado al mensaje
    public car getcar() {
        return car;
    }
    public void setcar(car car) {
        this.car = car;
    }

     //se estable el get set del cliente asociado al mensaje
     public Client getclient() {
        return client;
    }
    public void setclient(Client client) {
        this.client = client;
    }

    //se estable el get set de fechaEntrega
    public Integer getscore() {
        return score;
    }
    public void setscore(Integer score) {
        this.score = score;
    }

}
