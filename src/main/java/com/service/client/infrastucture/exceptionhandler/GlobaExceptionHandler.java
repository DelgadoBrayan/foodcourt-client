package com.service.client.infrastucture.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.client.infrastucture.exception.InvalidClientException;

public class GlobaExceptionHandler {
    
    @ExceptionHandler(InvalidClientException.class)
    public ResponseEntity<String> handleInvalidClientException(InvalidClientException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}