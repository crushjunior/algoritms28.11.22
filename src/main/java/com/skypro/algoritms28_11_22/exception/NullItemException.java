package com.skypro.algoritms28_11_22.exception;

public class NullItemException extends RuntimeException{
    public NullItemException() {
    }

    public NullItemException(String message) {
        super(message);
    }
}
