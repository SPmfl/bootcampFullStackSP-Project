package com.sophos.sophosbank.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transaction_id;
    private long account_number_from;
    @Nullable
    private long account_number_to;
    private String transaction_description;
    private String transaction_type_m;
    private double transaction_value;
    private double transaction_balance;
    private double transaction_balance_available;
    private LocalDate transaction_creation_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getAccount_number_from() {
        return account_number_from;
    }

    public void setAccount_number_from(long account_number_from) {
        this.account_number_from = account_number_from;
    }

    public long getAccount_number_to() {
        return account_number_to;
    }

    public void setAccount_number_to(long account_number_to) {
        this.account_number_to = account_number_to;
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
