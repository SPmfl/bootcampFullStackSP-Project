package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public List<Client> getAllClients();
    public Optional<Client> getClient(long client_id);
    public Client createClient(Client client);
    public boolean deleteClient(long client_id);
    public boolean updateClient(long client_id, Client client);

}
