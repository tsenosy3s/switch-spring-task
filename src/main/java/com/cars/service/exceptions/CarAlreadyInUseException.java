package com.cars.service.exceptions;

public class CarAlreadyInUseException extends Exception{
    public CarAlreadyInUseException(String errorMessage) {
        super(errorMessage);
    }
}
