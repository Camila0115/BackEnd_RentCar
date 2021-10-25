package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
/**
 * Clase car
 */
public class Carro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * declara el id del carro
     */
    private Integer idCar;
    /**
     * declara el nombre del carro
     */
    private String name;
    /**
     * declara la marca del carro
     */
    private String brand;
    /**
     * declara el year del carro
     */
    private Integer year;
    /**
     * declara la descripcion del carro
     */
    private String description;
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    Gama gama;
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "car")
    @JsonIgnoreProperties({ "car", "client" })
    Set<Message> messages;
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "car")
    @JsonIgnoreProperties({ "car", "client" })
    List<Reservation> reservations;

    /**
     * se estable el get de id
     */
    public Integer getidCar() {
        return idCar;
    }

    /**
     * se estable el set de id
     */
    public void setidCar(Integer id) {
        this.idCar = id;
    }

    /**
     * se estable el get de name
     */
    public String getname() {
        return name;
    }

    /**
     * se estable el set de name
     */
    public void setname(String nombre) {
        this.name = nombre;
    }

    /**
     * se estable el get de brand
     */
    public String getbrand() {
        return brand;
    }

    /**
     * se estable el set de brand
     */
    public void setbrand(String marca) {
        this.brand = marca;
    }

    /**
     * se estable el get de year
     */
    public Integer getyear() {
        return year;
    }

    /**
     * se estable el set de year
     */
    public void setyear(Integer ano) {
        this.year = ano;
    }

    /**
     * se estable el get de description
     */
    public String getdescription() {
        return description;
    }

    /**
     * se estable el set de description
     */
    public void setdescription(String descripcion) {
        this.description = descripcion;
    }

    /**
     * se estable el get de gama
     */
    public Gama getgama() {
        return gama;
    }

    /**
     * se estable el set de gama
     */
    public void setgama(Gama gama) {
        this.gama = gama;
    }

    /**
     * se estable el get de messages
     */
    public Set<Message> getmessages() {
        return messages;
    }

    /**
     * se estable el set de messages
     */
    public void setmessages(Set<Message> messages) {
        this.messages = messages;
    }

    /**
     * se estable el get de reservations
     */
    public List<Reservation> getreservations() {
        return reservations;
    }

    /**
     * se estable el set de reservations
     */
    public void setreservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
