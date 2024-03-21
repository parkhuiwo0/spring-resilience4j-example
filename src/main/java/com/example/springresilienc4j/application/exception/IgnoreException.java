package com.example.springresilienc4j.application.exception;

public class IgnoreException extends RuntimeException {

    public IgnoreException(String message) {
        super(message);
    }

    public IgnoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
