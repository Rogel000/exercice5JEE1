package org.example.exercice5jee.entity;

import jdk.jfr.Enabled;

import java.time.LocalDate;


public class Car {
    private long id;
    private String brand;
    private String year;
    private String color;

    public Car(long id, String brand, String year, String color) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public Car(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
