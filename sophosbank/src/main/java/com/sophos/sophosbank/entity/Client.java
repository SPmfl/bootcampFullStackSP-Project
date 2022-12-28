package com.sophos.sophosbank.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="clients",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "client_email"))
public class Client {

    public Client(){}

    public Client(long id,
                  String id_type,
                  long client_id,
                  String client_name,
                  String client_surname,
                  LocalDate client_birthdate,
                  String client_email,
                  String creation_user,
                  String last_modification_user,
                  LocalDateTime last_modification_date,
                  LocalDate creation_date) {
        this.id = id;
        this.id_type = id_type;
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_surname = client_surname;
        this.client_birthdate = client_birthdate;
        this.client_email = client_email;
        this.creation_user = creation_user;
        this.last_modification_user = last_modification_user;
        this.last_modification_date = last_modification_date;
        this.creation_date = creation_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_type;
    private long client_id;
    private String client_name;
    private String client_surname;
    private LocalDate client_birthdate;

    private String client_email;
    private String creation_user;
    private String last_modification_user;
    private LocalDateTime last_modification_date;
    private LocalDate creation_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_surname() {
        return client_surname;
    }

    public void setClient_surname(String client_surname) {
        this.client_surname = client_surname;
    }

    public LocalDate getClient_birthdate() {
        return client_birthdate;
    }

    public void setClient_birthdate(LocalDate client_birthdate) {
        this.client_birthdate = client_birthdate;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getCreation_user() {
        return creation_user;
    }

    public void setCreation_user(String creation_user) {
        this.creation_user = creation_user;
    }

    public String getLast_modification_user() {
        return last_modification_user;
    }

    public void setLast_modification_user(String last_modification_user) {
        this.last_modification_user = last_modification_user;
    }

    public LocalDateTime getLast_modification_date() {
        return last_modification_date;
    }

    public void setLast_modification_date(LocalDateTime last_modification_date) {
        this.last_modification_date = last_modification_date;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }
}
