package com.cars.service.services.manufacturers;

import com.cars.service.entites.Manufacturer;
import com.cars.service.models.manufacturers.ManufacturerBody;
import javassist.NotFoundException;

import java.util.List;

public interface IManufacturerService {

    public List<Manufacturer> list();

    public Manufacturer get(Long id) throws NotFoundException;

    public Manufacturer add(ManufacturerBody body);

    public Manufacturer update(long id,ManufacturerBody body) throws NotFoundException;

}
