package com.service.client.application.handler;

import org.springframework.stereotype.Service;

import com.service.client.application.dto.client.ClientRequest;
import com.service.client.application.mapper.ClientMapper;
import com.service.client.domain.api.IClientServicePort;
import com.service.client.domain.model.client.Client;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientHandler {
    private final IClientServicePort clientServicePort;

    public ClientRequest saveClient(ClientRequest dto){
        Client client = ClientMapper.INSTANCE.toEntity(dto);
        Client saveClient = clientServicePort.savaClient(client);
        return ClientMapper.INSTANCE.toDto(saveClient);
    }
}
