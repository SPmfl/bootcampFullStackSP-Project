package com.sophos.sophosbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sophos.sophosbank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}