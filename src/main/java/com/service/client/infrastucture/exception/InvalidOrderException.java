package com.service.client.infrastucture.exception;

public class InvalidOrderException extends RuntimeException{
    
    public InvalidOrderException(String message){
        super(message);
    }
}
