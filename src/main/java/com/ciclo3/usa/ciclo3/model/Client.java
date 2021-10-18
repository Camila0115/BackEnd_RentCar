package com.ciclo3.usa.ciclo3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    List<Message> messages;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    List<Reservation> reservation;
    

    // se estable el get set de id
    public Integer getidClient() {
        return idClient;
    }
    public void setidClient(Integer idClient) {
        this.idClient = idClient;
    }

    // se estable el get set de correo
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    
    // se estable el get set de Contrasena
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }

    // se estable el get set de nombre
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    // se estable el get set de edad
    public Integer getage() {
        return age;
    }
    public void setage(Integer age) {
        this.age = age;
    }

    // se estable el get set de los mensajes asociados a un cliente
    public List<Message> getmessages() {
        return messages;
    }
    public void setmessages(List<Message> messages) {
        this.messages = messages;
    }
    
    // se estable el get set de las reservaciones asociadas a un cliente
    public List<Reservation> getreservation() {
        return reservation;
    }
    public void setreservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

}
