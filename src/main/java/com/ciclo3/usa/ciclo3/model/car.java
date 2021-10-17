package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    @JoinColumn(name = "Gama")
    Gama gama;

    //se estable el get set de id
    public Integer getId() {
        return idCar;
    }
    public void setId(Integer id) {
        this.idCar = id;
    }

    //se estable el get set de nombre
    public String getNombre() {
        return name;
    }
    public void setNombre(String nombre) {
        this.name = nombre;
    }

    //se estable el get set de marca
    public String getMarca() {
        return brand;
    }
    public void setMarca(String marca) {
        this.brand = marca;
    }

    //se estable el get set de year
    public Integer getAno() {
        return year;
    }
    public void setAno(Integer ano) {
        this.year = ano;
    }

    //se estable el get set de descripcion
    public String getDescription() {
        return description;
    }
    public void setDescription(String descripcion) {
        this.description = descripcion;
    }
}
