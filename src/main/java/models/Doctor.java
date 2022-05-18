package models;

import java.util.List;

public class Doctor {

    private Long id;
    private String name;
    private String speciality;

    private List<Patient> patients;


    // Constructors
    public Doctor() {
    }

    public Doctor(String name, String speciality, List<Patient> patients) {
        this.name = name;
        this.speciality = speciality;
        this.patients = patients;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", patients=" + patients +
                '}';
    }
}