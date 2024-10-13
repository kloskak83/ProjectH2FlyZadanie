package com.ProjectH2Fly.exceptions;

public class Custom400Exception extends RuntimeException{

    public Custom400Exception() {
    }

    public Custom400Exception(String message) {
        super(message);
    }

    public Custom400Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Custom400Exception(Throwable cause) {
        super(cause);
    }
}
