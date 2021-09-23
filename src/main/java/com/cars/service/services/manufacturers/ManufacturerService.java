package com.cars.service.services.manufacturers;
import com.cars.service.entites.Manufacturer;
import com.cars.service.models.manufacturers.ManufacturerBody;
import com.cars.service.repositories.manufacturers.ManufacturerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService implements IManufacturerService  {

    @Autowired
    ManufacturerRepository manrepo;


    @Override
    public List<Manufacturer> list() {
        return manrepo.findAll();
    }

    @Override
    public Manufacturer get(Long id) throws NotFoundException {
        return manrepo.findById(id).orElseThrow(()->new NotFoundException("Item not found"));
    }

    @Override
    public Manufacturer add(ManufacturerBody body)  {
       Manufacturer man = new Manufacturer(body.name);
       return  manrepo.save(man);
    }

    @Override
    public Manufacturer update(long id, ManufacturerBody body) throws NotFoundException {
        Manufacturer man= manrepo.findById(id).orElseThrow(()->new NotFoundException("Item not found"));
        man.setName(body.name);
        return manrepo.save(man);
    }
}
