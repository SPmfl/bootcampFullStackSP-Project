package com.sophos.sophosbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sophos.sophosbank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
