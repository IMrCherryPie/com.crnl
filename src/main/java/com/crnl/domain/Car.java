package com.crnl.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "tcar")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String stateNumber;

    private String brand;

    private String model;

    private String color;

    private Date yearOfManufacture;

    private String vinBody;

    private String vinEngine;

    private Double costOfRental;

    private boolean inRental;

    private String registrationCertificate;

    private String filename;

    public Car() {
    }

    public Car(
            String stateNumber,
            String brand,
            String model,
            String color,
            Date yearOfManufacture,
            String vinBody,
            String vinEngine,
            Double   costOfRental,
            Boolean inRental,
            String  registrationCertificate

    ){
        this.stateNumber = stateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.vinBody = vinBody;
        this.vinEngine = vinEngine;
        this.costOfRental = costOfRental;
        this.inRental = inRental;
        this.registrationCertificate =registrationCertificate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVinBody() {
        return vinBody;
    }

    public void setVinBody(String vinBody) {
        this.vinBody = vinBody;
    }

    public String getVinEngine() {
        return vinEngine;
    }

    public void setVinEngine(String vinEngine) {
        this.vinEngine = vinEngine;
    }

    public Double getCostOfRental() {
        return costOfRental;
    }

    public void setCostOfRental(Double costOfRental) {
        this.costOfRental = costOfRental;
    }

    public boolean isInRental() {
        return inRental;
    }

    public void setInRental(boolean inRental) {
        this.inRental = inRental;
    }

    public String getRegistrationCertificate() {
        return registrationCertificate;
    }

    public void setRegistrationCertificate(String registrationCertificate) {
        this.registrationCertificate = registrationCertificate;
    }
}
