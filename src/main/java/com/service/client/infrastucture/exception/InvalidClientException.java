package com.service.client.infrastucture.exception;

public class InvalidClientException extends RuntimeException{
    
    public InvalidClientException(String message){
        super(message);
    }
}
