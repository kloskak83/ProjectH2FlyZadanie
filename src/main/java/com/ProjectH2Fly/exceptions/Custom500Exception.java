package com.ProjectH2Fly.exceptions;

public class Custom500Exception extends RuntimeException {
    public Custom500Exception() {
    }

    public Custom500Exception(String message) {
        super(message);
    }

    public Custom500Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Custom500Exception(Throwable cause) {
        super(cause);
    }
}
