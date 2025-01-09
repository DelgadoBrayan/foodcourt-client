package com.service.client.infrastucture.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.client.application.dto.client.ClientRequest;
import com.service.client.application.handler.ClientHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/square/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientHandler clientHandler;

    @PostMapping()
     public ResponseEntity<Void> createEmployee(@Valid @RequestBody ClientRequest clientRequest) {
        clientHandler.saveClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
