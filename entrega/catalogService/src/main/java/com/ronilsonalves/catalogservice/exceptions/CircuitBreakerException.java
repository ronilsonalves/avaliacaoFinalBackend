package com.ronilsonalves.catalogservice.exceptions;

public class CircuitBreakerException extends Exception{

    public CircuitBreakerException(String message) {
        super(message);
    }
}
