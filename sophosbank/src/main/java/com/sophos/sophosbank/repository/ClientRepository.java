package com.sophos.sophosbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sophos.sophosbank.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
