package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Client;
import com.sophos.sophosbank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return Optional.empty();
    }

    @Override
    public Client createClient(Client client) {
        return null;
    }

    @Override
    public boolean deleteClient(long client_id) {
        return false;
    }
}
