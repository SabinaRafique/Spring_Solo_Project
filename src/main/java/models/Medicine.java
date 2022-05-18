package models;

import java.util.ArrayList;
import java.util.List;

public class Medicine {

    private Long id;
    private String name;
    private float price;

    private List<Patient> patients;


    // Constructors
    public Medicine() {
    }

    public Medicine(String name, float price) {
        this.name = name;
        this.price = price;
        this.patients = new ArrayList<>();
    }


    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", patients=" + patients +
                '}';
    }
}
