package com.service.client.domain.api;

import com.service.client.domain.model.client.Client;

public interface IClientServicePort {
    Client savaClient(Client client);
}
