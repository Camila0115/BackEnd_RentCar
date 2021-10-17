package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer valores;
    private String mensaje;
    private Integer reserva ;

    //se estable el get set de id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //se estable el get set de valores
    public Integer getValores() {
        return valores;
    }
    public void setValores(Integer valores) {
        this.valores = valores;
    }

    //se estable el get set de mensaje
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //se estable el get set de reserva
    public Integer getReserva() {
        return reserva;
    }
    public void setReserva(Integer reserva) {
        this.reserva = reserva;
    }

}
