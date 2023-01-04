package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Customer;
import com.sophos.sophosbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(long customer_id) {
        return customerRepository.findById(customer_id);
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        /*validate user input*/
        Customer customer = new Customer();
                    customer.setId_type(newCustomer.getId_type());
                    customer.setCustomer_id(newCustomer.getCustomer_id());
                    customer.setCustomer_name(newCustomer.getCustomer_name());
                    customer.setCustomer_surname(newCustomer.getCustomer_surname());
                    customer.setCustomer_birthdate(newCustomer.getCustomer_birthdate());
                    customer.setCustomer_email(newCustomer.getCustomer_email());
                    customer.setCustomer_phone(newCustomer.getCustomer_phone());


        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(long customer_id) {
        return this.getCustomer(customer_id).map(customer ->{
            customerRepository.deleteById(customer_id);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean updateCustomer(long customer_id, Customer newCustomer) {
        Optional<Customer> optionalCustomer = this.getCustomer(customer_id);

        if(optionalCustomer.isEmpty()) return false;

        Customer customer = optionalCustomer.get();
            customer.setId_type(newCustomer.getId_type());
            customer.setCustomer_id(newCustomer.getCustomer_id());
            customer.setCustomer_name(newCustomer.getCustomer_name());
            customer.setCustomer_surname(newCustomer.getCustomer_surname());
            customer.setCustomer_birthdate(
                (this.verifyAge(newCustomer.getCustomer_birthdate())) ?
                        newCustomer.getCustomer_birthdate():
                        customer.getCustomer_birthdate());
            customer.setCustomer_email(
                (this.verifyEmail(customer.getCustomer_email()))?
                        newCustomer.getCustomer_email():
                        customer.getCustomer_email());
            customer.setLast_modification_user("admin");
            customer.setLast_modification_date(LocalDateTime.now());

        customerRepository.save(customer);
        return true;
    }

    public boolean verifyAge(LocalDate age){
        int years = Period.between(age, LocalDate.now()).getYears();
        return years >= 18;
    }

    public boolean verifyEmail(String email){
        final String EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9._-]*\\@\\w+(\\.)*\\w+\\.\\w+$";
        final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}
