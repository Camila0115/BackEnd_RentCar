package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gama")
public class Gama implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGama;
    private String name;
    private String description;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "gama")
    @JsonIgnoreProperties("gama")
    List<car> cars;

    //se estable el get set de id
    public Integer getidGama() {
        return idGama;
    }
    public void setidGama(Integer id) {
        this.idGama = id;
    }

    //se estable el get set de nombre
    public String getname() {
        return name;
    }
    public void setNombre(String nombre) {
        this.name = nombre;
    }

    //se estable el get set de descripcion
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }

    public List<car> getcars() {
        return cars;
    }
    public void setcars(List<car> cars) {
        this.cars = cars;
    }

}
