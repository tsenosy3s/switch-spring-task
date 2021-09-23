package com.cars.service.entites;

import com.cars.service.entites.enums.EngineType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;


@Entity
@Table(name = "cars")
public class Car   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "seat_count")
    private Integer seatCount;
    @Column(name = "convertible")
    private Boolean convertible;
    @Column(name = "rating")
    private Integer rating;

    @Column(name = "date_created" ,nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type")
    private EngineType engineType;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id",
            referencedColumnName = "id",
            nullable = false)
    private Manufacturer manufacturer;


    @ManyToMany (mappedBy = "cars")
    private Set<Driver> drivers;

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Car(){
    }

    public Car( String licensePlate, Integer seatCount, Boolean convertible,
               Integer rating, EngineType engineType, Manufacturer manufacturer) {

        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


}
