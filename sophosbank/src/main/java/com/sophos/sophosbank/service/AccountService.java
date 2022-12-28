package com.sophos.sophosbank.service;

import com.sophos.sophosbank.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAllAccounts();
    public List<Account> getAllClientAccounts(long client_id);
    public Optional<Account> getAccount(long client_id);
    public Account createAccount(Account account);
    public boolean deleteAccount(long account_id);
    public boolean updateAccount(long account_id, Account account);
}
