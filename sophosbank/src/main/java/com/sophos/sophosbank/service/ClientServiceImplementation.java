package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Client;
import com.sophos.sophosbank.repository.ClientRepository;
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
public class ClientServiceImplementation implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClient(long client_id) {
        return clientRepository.findById(client_id);
    }

    @Override
    public Client createClient(Client client) {
        /*validate user input*/
        return clientRepository.save(client);
    }

    @Override
    public boolean deleteClient(long client_id) {
        return this.getClient(client_id).map( client ->{
            clientRepository.deleteById(client_id);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean updateClient(long client_id, Client newClient) {
        Client client = this.getClient(client_id).get();
        client.setId_type(newClient.getId_type());
        client.setClient_id(newClient.getClient_id());
        client.setClient_name(newClient.getClient_name());
        client.setClient_surname(newClient.getClient_surname());
        client.setClient_birthdate(
                (this.verifyAge(newClient.getClient_birthdate())) ?
                        newClient.getClient_birthdate():
                        client.getClient_birthdate());
        client.setClient_email(
                (this.verifyEmail(client.getClient_email()))?
                        newClient.getClient_email():
                        client.getClient_email());
        client.setLast_modification_user("admin");
        client.setLast_modification_date(LocalDateTime.now());
            return true;
    }

    public boolean verifyAge(LocalDate age){
        int years = Period.between(age, LocalDate.now()).getYears();
        if(years >= 18)
            return true;
        return false;
    }

    public boolean verifyEmail(String email){
        final String EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9._-]*\\@\\w+(\\.)*\\w+\\.\\w+$";
        final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}
