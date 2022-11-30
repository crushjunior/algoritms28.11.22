package com.skypro.algoritms28_11_22.exception;

public class InvalidIndexException extends RuntimeException{
    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }
}
