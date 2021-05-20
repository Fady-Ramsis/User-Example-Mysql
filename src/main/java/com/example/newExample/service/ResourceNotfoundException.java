package com.example.newExample.service;

public class ResourceNotfoundException extends RuntimeException{
    public ResourceNotfoundException() {
    }

    public ResourceNotfoundException(String message) {
        super(message);
    }

    public ResourceNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotfoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotfoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
