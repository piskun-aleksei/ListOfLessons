package com.bsuir.piskun.exceptions;

public class HashCreationException extends Exception {

    public HashCreationException() {
    }

    public HashCreationException(String message) {
        super(message);
    }

    public HashCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HashCreationException(Throwable cause) {
        super(cause);
    }

    public HashCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
