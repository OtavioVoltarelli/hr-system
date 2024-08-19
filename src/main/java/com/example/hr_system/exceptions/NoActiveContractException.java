package com.example.hr_system.exceptions;

public class NoActiveContractException extends RuntimeException{
    public NoActiveContractException(String message) {
        super(message);
    }

    public NoActiveContractException() {
    }
}
