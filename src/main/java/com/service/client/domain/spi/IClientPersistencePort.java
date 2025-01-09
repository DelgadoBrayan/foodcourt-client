package com.service.client.domain.spi;

import com.service.client.domain.model.client.Client;

public interface IClientPersistencePort {
    Client saveClient(Client client);
}
