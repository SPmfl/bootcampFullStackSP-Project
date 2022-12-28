package com.sophos.sophosbank.controller;

import com.sophos.sophosbank.entity.Transaction;
import com.sophos.sophosbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> getAccountTransactions(@PathVariable("id") long account_id){
        return new ResponseEntity<>(transactionService.getAccountTransactions(account_id), HttpStatus.OK);
    }
}
