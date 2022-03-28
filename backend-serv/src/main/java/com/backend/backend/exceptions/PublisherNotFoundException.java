package com.backend.backend.exceptions;

public class PublisherNotFoundException extends RuntimeException{
    public PublisherNotFoundException(String message){
        super(message);
    }
}
