package com.example.demo.commom.ObjectTest;

public class BussinesException  extends RuntimeException{


    public BussinesException() {
    }

    public BussinesException(String message) {
        super(message);
    }

    public BussinesException(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinesException(Throwable cause) {
        super(cause);
    }

    public BussinesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
