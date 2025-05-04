package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {

    @Id
    private int id;
    private String brand;
    private String model;
    @ManyToMany(mappedBy = "laptops")
    private List<Student> students;
    public Laptop() {
    }

    public Laptop(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
