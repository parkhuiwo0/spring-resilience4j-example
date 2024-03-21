package com.example.springresilienc4j.application.exception;

public class CircuitException extends RuntimeException {

    public CircuitException(String message) {
        super(message);
    }

    public CircuitException(String message, Throwable cause) {
        super(message, cause);
    }
}
