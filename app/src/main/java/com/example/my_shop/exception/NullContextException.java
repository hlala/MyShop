package com.example.my_shop.exception;

public class NullContextException extends Exception {
    public NullContextException() {
        super();
    }

    public NullContextException(String message) {
        super(message);
    }

    public NullContextException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullContextException(Throwable cause) {
        super(cause);
    }

    protected NullContextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
