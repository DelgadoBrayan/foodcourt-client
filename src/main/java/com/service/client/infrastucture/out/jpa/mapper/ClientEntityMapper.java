package com.service.client.infrastucture.out.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.service.client.domain.model.client.Client;
import com.service.client.infrastucture.out.jpa.entity.ClientEntity;

@Mapper(componentModel ="spring")
public interface ClientEntityMapper {
    ClientEntityMapper INSTANCE = Mappers.getMapper(ClientEntityMapper.class);

    @Mapping(source = "client.contactInfo.documentId", target = "documentId")
    @Mapping(source = "client.contactInfo.phone", target = "phone")
    @Mapping(source = "client.contactInfo.email", target = "email")
    ClientEntity toEntity(Client client);

    @Mapping(source = "entity.documentId", target = "contactInfo.documentId")
    @Mapping(source = "entity.phone", target = "contactInfo.phone")
    @Mapping(source = "entity.email", target = "contactInfo.email")
    Client toDomain(ClientEntity entity);
}
