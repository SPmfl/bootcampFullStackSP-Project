package com.sophos.sophosbank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    private long id;
    private long account_number;
    private String transaction_description;
    private double transaction_value;
    private String transaction_type_m;
    private double transaction_balance;
    private double transaction_balance_available;
    private LocalDate transaction_creation_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getTransaction_description() {
        return transaction_description;
    }

    public void setTransaction_description(String transaction_description) {
        this.transaction_description = transaction_description;
    }

    public double getTransaction_value() {
        return transaction_value;
    }

    public void setTransaction_value(double transaction_value) {
        this.transaction_value = transaction_value;
    }

    public String getTransaction_type_m() {
        return transaction_type_m;
    }

    public void setTransaction_type_m(String transaction_type_m) {
        this.transaction_type_m = transaction_type_m;
    }

    public double getTransaction_balance() {
        return transaction_balance;
    }

    public void setTransaction_balance(double transaction_balance) {
        this.transaction_balance = transaction_balance;
    }

    public double getTransaction_balance_available() {
        return transaction_balance_available;
    }

    public void setTransaction_balance_available(double transaction_balance_available) {
        this.transaction_balance_available = transaction_balance_available;
    }

    public LocalDate getTransaction_creation_date() {
        return transaction_creation_date;
    }

    public void setTransaction_creation_date(LocalDate transaction_creation_date) {
        this.transaction_creation_date = transaction_creation_date;
    }
}
