package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Transaction;
import com.sophos.sophosbank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImplementation implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public List<Transaction> getAccountTransactions(long account_id) {
        List<Transaction> list = transactionRepository
                                    .findAll()
                                    .stream()
                                    .filter(t -> t.getAccount_number_from()==account_id)
                                    .collect(Collectors.toList());
        return  list;
    }

    @Override
    public boolean createTransaction(Transaction transaction) {
        return false;
    }

    @Override
    public boolean deleteTransaction(long account_id) {
        return false;
    }

    @Override
    public Optional<Transaction> updateTransaction(long transaction_id) {
        return Optional.empty();
    }
}
