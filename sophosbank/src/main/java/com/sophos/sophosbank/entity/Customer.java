package com.sophos.sophosbank.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = "customer_email"))
public class Customer {

    public Customer() {
    }

    public Customer(long id,
            String id_type,
            long customer_id,
            String customer_name,
            String customer_surname,
            LocalDate customer_birthdate,
            String customer_email,
            String creation_user,
            String last_modification_user,
            LocalDateTime last_modification_date,
            LocalDate creation_date) {
        this.id = id;
        this.id_type = id_type;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_surname = customer_surname;
        this.customer_birthdate = customer_birthdate;
        this.customer_email = customer_email;
        this.creation_user = creation_user;
        this.last_modification_user = last_modification_user;
        this.last_modification_date = last_modification_date;
        this.creation_date = creation_date;
    }

    public Customer(
            String id_type,
            long customer_id,
            String customer_name,
            String customer_surname,
            LocalDate customer_birthdate,
            String customer_email,
            String customer_phone) {

        this.id_type = id_type;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_surname = customer_surname;
        this.customer_birthdate = customer_birthdate;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_type;
    private long customer_id;
    private String customer_name;
    private String customer_surname;
    private LocalDate customer_birthdate;
    private String customer_phone;
    private String customer_email;

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

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }

    public void setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
    }

    public LocalDate getCustomer_birthdate() {
        return customer_birthdate;
    }

    public void setCustomer_birthdate(LocalDate customer_birthdate) {
        this.customer_birthdate = customer_birthdate;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
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
