package com.practice.interview.errors;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException(final String message) {
        super(message);
    }
}
