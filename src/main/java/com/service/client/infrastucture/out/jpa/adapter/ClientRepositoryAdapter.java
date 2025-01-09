package com.service.client.infrastucture.out.jpa.adapter;

import com.service.client.domain.model.client.Client;
import com.service.client.domain.spi.IClientPersistencePort;
import com.service.client.infrastucture.out.jpa.entity.ClientEntity;
import com.service.client.infrastucture.out.jpa.mapper.ClientEntityMapper;
import com.service.client.infrastucture.out.jpa.repository.ClientJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientRepositoryAdapter implements IClientPersistencePort {
    private final ClientJpaRepository clientJpa;
    private final ClientEntityMapper clientMapper;

    @Override
    public Client saveClient(Client client) {

       ClientEntity entity = clientMapper.toEntity(client);
       ClientEntity saveClient = clientJpa.save(entity);

        return clientMapper.toDomain(saveClient);
    }

}
