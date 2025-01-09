package com.service.client.application.dto.client;

import lombok.Data;

@Data
public class ClientRequest {
    private String id;
    private String fistName;
    private String lastName;
    private Long idRol;
    private String password;
    private String documentId;
    private String phone;
    private String email; 
}
 