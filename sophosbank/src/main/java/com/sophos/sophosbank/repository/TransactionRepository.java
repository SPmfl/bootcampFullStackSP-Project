package com.sophos.sophosbank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sophos.sophosbank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
