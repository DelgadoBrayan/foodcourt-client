package com.service.client.domain.usecase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.service.client.domain.api.IClientServicePort;
import com.service.client.domain.model.client.Client;
import com.service.client.domain.model.client.ContactInfo;
import com.service.client.domain.spi.IClientPersistencePort;
import com.service.client.infrastucture.exception.InvalidClientException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientUseCase implements IClientServicePort {
    private final IClientPersistencePort clientPersistencePort;

    @Override
    public Client savaClient(Client client) {
        
        validateClienteFields(client);
        //falta crear cuenta con tipó cliente 
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(encodePassword);
    
        return clientPersistencePort.saveClient(client);
    }

    private void validateClienteFields(Client client) {
    ContactInfo contactInfo = client.getContactInfo();
    if (isNullOrEmpty(client.getLastName())) {
        throw new InvalidClientException("El apellido del empleado no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(client.getLastName())) {
        throw new InvalidClientException("El nombre del empleado no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(contactInfo.getDocumentId())) {
        throw new InvalidClientException("El documento de identidad no debe estar vacío o nulo");
    }
    if (isNullOrEmpty(contactInfo.getPhone()) || !contactInfo.getPhone().matches("\\+?\\d{1,13}")) {
        throw new InvalidClientException("El celular debe ser numérico, con un máximo de 13 caracteres, y puede incluir '+'");
    }
    if (isNullOrEmpty(contactInfo.getEmail()) || !contactInfo.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
        throw new InvalidClientException("El correo debe tener un formato válido");
    }
    if (isNullOrEmpty(client.getPassword())) {
        throw new InvalidClientException("La contraseña no debe estar vacía o nula");
    }
}

private boolean isNullOrEmpty(String value) {
    return value == null || value.trim().isEmpty();
}
}
