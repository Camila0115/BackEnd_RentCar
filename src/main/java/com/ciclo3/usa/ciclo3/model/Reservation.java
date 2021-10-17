package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer carro;
    private Integer cliente;
    private Date fechaInicio;
    private Date fechaEntrega;

    //se estable el get set de id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //se estable el get set de carro
    public Integer getCarro() {
        return carro;
    }
    public void setCarro(Integer carro) {
        this.carro = carro;
    }

    //se estable el get set de cliente
    public Integer getCliente() {
        return cliente;
    }
    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    //se estable el get set de fechaInicio
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    //se estable el get set de fechaEntrega
    public Date getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

}
