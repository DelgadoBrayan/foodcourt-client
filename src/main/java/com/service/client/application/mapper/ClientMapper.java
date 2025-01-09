package com.service.client.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.service.client.application.dto.client.ClientRequest;
import com.service.client.domain.model.client.Client;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "dto.documentId", target = "contactInfo.documentId")
    @Mapping(source = "dto.phone", target = "contactInfo.phone")
    @Mapping(source = "dto.email", target = "contactInfo.email")
    Client toEntity(ClientRequest dto);

    @Mapping(source = "client.contactInfo.documentId", target = "documentId")
    @Mapping(source = "client.contactInfo.phone", target = "phone")
    @Mapping(source = "client.contactInfo.email", target = "email")
    ClientRequest toDto(Client client); 
}
