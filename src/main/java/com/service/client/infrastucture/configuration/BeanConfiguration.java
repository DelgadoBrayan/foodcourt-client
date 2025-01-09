package com.service.client.infrastucture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.client.domain.api.IClientServicePort;
import com.service.client.domain.spi.IClientPersistencePort;
import com.service.client.domain.usecase.ClientUseCase;
import com.service.client.infrastucture.out.jpa.adapter.ClientRepositoryAdapter;
import com.service.client.infrastucture.out.jpa.mapper.ClientEntityMapper;
import com.service.client.infrastucture.out.jpa.repository.ClientJpaRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ClientEntityMapper clientEntityMapper;
    private final ClientJpaRepository clientJpaRepository;

    @Bean
    IClientPersistencePort clientPersistencePort(){
        return new ClientRepositoryAdapter(clientJpaRepository, clientEntityMapper);
    }

    @Bean
    IClientServicePort clientServicePort(){
        return new ClientUseCase(clientPersistencePort());
    }
}
