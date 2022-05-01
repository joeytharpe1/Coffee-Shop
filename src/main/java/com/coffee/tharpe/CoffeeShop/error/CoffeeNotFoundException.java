package com.coffee.tharpe.CoffeeShop.error;

public class CoffeeNotFoundException extends Exception{

    public CoffeeNotFoundException() {
        super();
    }

    public CoffeeNotFoundException(String message) {
        super(message);
    }

    public CoffeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CoffeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
