package com.backend.backend.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message){
        super(message);
    }
}
