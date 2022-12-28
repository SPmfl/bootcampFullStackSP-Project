package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Account;
import com.sophos.sophosbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class AccountServiceImplementation implements AccountService{

    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAllClientAccounts(long client_id) {
        List<Account> accounts = this.getAllAccounts();
        return accounts
                .stream()
                .filter(acc -> acc.getClient_id()==client_id)
                .collect(toList());
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public boolean deleteAccount(long account_id) {
        if(this.getAccount(account_id).isPresent()){
            accountRepository.deleteById(account_id);
            return true;
        }
         return false;
    }

    @Override
    public Optional<Account> getAccount(long client_id) {
        return accountRepository.findById(client_id);
    }

    @Override
    public boolean updateAccount(long account_id, Account account) {
        return false;
    }
}
