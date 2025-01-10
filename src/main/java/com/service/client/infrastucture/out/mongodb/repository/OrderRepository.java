package com.service.client.infrastucture.out.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.client.infrastucture.out.mongodb.entity.EntityOrder;

@Repository
public interface OrderRepository extends MongoRepository<EntityOrder, String> {
    Optional<EntityOrder> findByIdClientAndStatusNot(Long idClient, String status);
}
