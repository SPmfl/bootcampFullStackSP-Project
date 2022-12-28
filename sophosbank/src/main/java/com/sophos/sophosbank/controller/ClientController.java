package com.sophos.sophosbank.controller;

import com.sophos.sophosbank.entity.Client;
import com.sophos.sophosbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<List<Client>>(clientService.getAllClients(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") long client_id){
        return clientService.getClient(client_id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.createClient(client),
                                   HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") long client_id){
        if (clientService.deleteClient(client_id)) return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable("id") long client_id, @RequestBody Client client){
        if(clientService.updateClient(client_id, client)) return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
