package com.example.hr_system.exceptions;

public class AlreadyDisableException extends RuntimeException{
    public AlreadyDisableException() {
    }

    public AlreadyDisableException(String message) {
        super(message);
    }
}
