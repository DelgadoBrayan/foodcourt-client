package com.service.client.infrastucture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.client.domain.api.IClientServicePort;
import com.service.client.domain.api.IOrderServicePort;
import com.service.client.domain.spi.IClientPersistencePort;
import com.service.client.domain.spi.IOrderPersistencePort;
import com.service.client.domain.usecase.ClientUseCase;
import com.service.client.domain.usecase.OrderUseCase;
import com.service.client.infrastucture.out.jpa.adapter.ClientRepositoryAdapter;
import com.service.client.infrastucture.out.jpa.mapper.ClientEntityMapper;
import com.service.client.infrastucture.out.jpa.repository.ClientJpaRepository;
import com.service.client.infrastucture.out.mongodb.adater.OrderRepositoryAdapter;
import com.service.client.infrastucture.out.mongodb.mapper.OrderEntityMapper;
import com.service.client.infrastucture.out.mongodb.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ClientEntityMapper clientEntityMapper;
    private final ClientJpaRepository clientJpaRepository;
    private final OrderEntityMapper orderEntityMapper;
    private final OrderRepository orderRepository;

    @Bean
    IClientPersistencePort clientPersistencePort(){
        return new ClientRepositoryAdapter(clientJpaRepository, clientEntityMapper);
    }

    @Bean
    IClientServicePort clientServicePort(){
        return new ClientUseCase(clientPersistencePort());
    }

    @Bean
    IOrderPersistencePort orderPersistencePort(){
        return new OrderRepositoryAdapter(orderRepository, orderEntityMapper);
    }

    @Bean
    IOrderServicePort orderServicePort(){
        return new OrderUseCase(orderPersistencePort());
    }
}
