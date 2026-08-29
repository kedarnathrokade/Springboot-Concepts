package com.springboot.FirstAPI.exceptions;

public class ResourceNotfoundException extends RuntimeException{
    public ResourceNotfoundException(String message) {
        super(message);
    }
}
