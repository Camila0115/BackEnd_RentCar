package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer carro ;
    private String texto ;

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

    //se estable el get set de texto
    public String getTexto() {
        return texto ;
    }
    public void setTexto(String texto ) {
        this.texto  = texto ;
    }

}
