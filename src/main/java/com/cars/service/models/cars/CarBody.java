package com.cars.service.models.cars;

import com.cars.service.entites.enums.EngineType;

import javax.persistence.Column;

public class CarBody {

    public String licensePlate;

    public Integer seatCount;

    public Boolean convertible;

    public Integer rating;

    public Long manufacturerId;

    public EngineType engineType;


}
