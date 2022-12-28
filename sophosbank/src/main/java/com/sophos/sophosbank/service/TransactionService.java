package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public List<Transaction> getAccountTransactions(long account_id);
    public boolean createTransaction(Transaction transaction);
    public boolean deleteTransaction(long account_id);
    public Optional<Transaction> updateTransaction(long transaction_id);

}
