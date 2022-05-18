package models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private LocalDate dob;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @ManyToMany
    @JoinTable(
            name = "patients_medications",
            joinColumns = {@JoinColumn(name = "patients_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "medication_id", nullable = false)}
    )
    private List<Medication> medicationList;


    //Constructors
    public Patient() {
    }

    public Patient(String name, String gender, LocalDate dob, String phoneNumber, String address, Doctor doctor) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.doctor = doctor;
        this.medicationList = new ArrayList<>();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Medication> getMedicineList() {
        return medicationList;
    }

    public void setMedicineList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", doctor=" + doctor +
                ", medicineList=" + medicationList +
                '}';
    }
}
