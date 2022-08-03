package com.imooc.uaa.repository;

import com.imooc.uaa.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);

    void deleteByClientId(String clientId);
}
