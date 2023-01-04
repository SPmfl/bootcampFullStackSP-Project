package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Optional<Customer> getCustomer(long client_id);
    public Customer createCustomer(Customer customer);
    public boolean deleteCustomer(long client_id);
    public boolean updateCustomer(long client_id, Customer customer);

    public boolean verifyAge(LocalDate age);

    public boolean verifyEmail(String email);

}
