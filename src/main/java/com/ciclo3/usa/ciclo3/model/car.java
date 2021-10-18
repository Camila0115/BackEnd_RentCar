package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "car")
public class car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    Gama gama;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties("car")
    List<Message> messages;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties("car")
    List<Reservation> reservation;

    //se estable el get set de id
    public Integer getidCar() {
        return idCar;
    }
    public void setidCar(Integer id) {
        this.idCar = id;
    }

    //se estable el get set de nombre
    public String getname() {
        return name;
    }
    public void setname(String nombre) {
        this.name = nombre;
    }

    //se estable el get set de marca
    public String getbrand() {
        return brand;
    }
    public void setbrand(String marca) {
        this.brand = marca;
    }

    //se estable el get set de year
    public Integer getyear() {
        return year;
    }
    public void setyear(Integer ano) {
        this.year = ano;
    }

    //se estable el get set de descripcion
    public String getdescription() {
        return description;
    }
    public void setdescription(String descripcion) {
        this.description = descripcion;
    }
    
    //se estable el get set la gama asociada al carro
    public Gama getgama() {
        return gama;
    }
    public void setgama(Gama gama) {
        this.gama = gama;
    }

    
    public List<Message> getmessages() {
        return messages;
    }
    public void setmessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getreservation() {
        return reservation;
    }
    public void setreservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}
