package com.example.car.models;


import javax.persistence.*;


@Entity
//@Table (name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcar;

    public Car(Long id, String name, String year_of_issue) {
        this.idcar = id;
        this.name = name;
        this.year = year_of_issue;
    }

    public Car(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public Car(){

    }

    private String name, year;

    public Long getIdcar() {
        return idcar;
    }

    public void setIdcar(Long idcar) {
        this.idcar = idcar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
