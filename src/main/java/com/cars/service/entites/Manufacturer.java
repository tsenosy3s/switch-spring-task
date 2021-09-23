package com.cars.service.entites;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_created")
    private ZonedDateTime dateCreated;
    @Column(name = "name")
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer(Long id, ZonedDateTime dateCreated, String name) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.name = name;
    }
    public Manufacturer() {}


}

