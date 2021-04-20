package com.camp.campApi.exception;

public class JWTDecodeException extends RuntimeException {

    public JWTDecodeException(String message) {
        super(message);
    }
}
