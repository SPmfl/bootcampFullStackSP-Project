package com.sophos.sophosbank.controller;

import com.sophos.sophosbank.entity.Client;
import com.sophos.sophosbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<List<Client>>(clientService.getAllClients(), HttpStatus.OK);
    }

}
