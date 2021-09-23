package com.cars.service.repositories.drivers;

import com.cars.service.entites.Car;
import com.cars.service.entites.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    List<Driver> findAllByCars(Car car);
}
