package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties({"messages","reservations"})
    Carro car;
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    Client client;
    

    //se estable el get set de id
    public Integer getidMessage() {
        return idMessage;
    }
    public void setidMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    //se estable el get set de texto
    public String getmessageText() {
        return messageText ;
    }
    public void setmessageText(String messageText ) {
        this.messageText  = messageText ;
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
}
