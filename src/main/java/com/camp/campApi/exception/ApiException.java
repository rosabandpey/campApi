package com.camp.campApi.exception;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}
