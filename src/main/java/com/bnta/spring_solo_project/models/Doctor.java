package com.bnta.spring_solo_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @ManyToMany
    @JoinTable(
            name = "doctors_medications",
            joinColumns = @JoinColumn(name = "doctor_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "medication_id", nullable = false)
    )
    private List<Medication> medications;


    // Constructors
    public Doctor() {
    }

    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
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

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    // Add/Remove Patients
    public void addPatient(Patient patient){
        this.patients.add(patient);
    }

    public void remove(Patient patient){
        this.patients.add(patient);
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", patients=" + patients +
                ", medications=" + medications +
                '}';
    }
}
