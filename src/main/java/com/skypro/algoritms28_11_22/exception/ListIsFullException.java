package com.skypro.algoritms28_11_22.exception;

public class ListIsFullException extends RuntimeException{
    public ListIsFullException() {
    }

    public ListIsFullException(String message) {
        super(message);
    }
}
