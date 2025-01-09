package com.service.client.infrastucture.out.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.client.infrastucture.out.jpa.entity.ClientEntity;


public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
    
}
