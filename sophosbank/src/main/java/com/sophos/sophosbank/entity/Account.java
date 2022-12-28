package com.sophos.sophosbank.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long client_id;
    private String account_type;
    private long account_number;
    private String account_status;
    private double account_balance;
    private double account_balance_available;
    private boolean account_gmf_status;
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

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public double getAccount_balance_available() {
        return account_balance_available;
    }

    public void setAccount_balance_available(double account_balance_available) {
        this.account_balance_available = account_balance_available;
    }

    public boolean isAccount_gmf_status() {
        return account_gmf_status;
    }

    public void setAccount_gmf_status(boolean account_gmf_status) {
        this.account_gmf_status = account_gmf_status;
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
