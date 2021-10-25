package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    //private Date startDate;
    //private Date devolutionDate;
    private String startDate;
    private String devolutionDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties("reservations")
    Carro car;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    Client client;
    
    @OneToOne
    @JoinColumn(name = "idScore")
    @JsonIgnoreProperties({"vvv","ddd"})
    Score score;
   

    //se estable el get set de id
    public Integer getidReservation() {
        return idReservation;
    }
    public void setidReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    //se estable el get set de fechaInicio
    public String getstartDate() {
        return startDate;
    }
    public void setstartDate(String startDate) {
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
    public String getdevolutionDate() {
        return devolutionDate;
    }
    public void setdevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    
    //se estable el get set  del carro asociado al mensaje
    public Carro getcar() {
        return car;
    }
    public void setcar(Carro car) {
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
    public Score getscore() {
        return score;
    }
    public void setscore(Score score) {
        this.score = score;
    }

}
