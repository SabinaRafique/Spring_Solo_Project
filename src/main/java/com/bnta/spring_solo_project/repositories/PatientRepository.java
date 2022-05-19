package com.bnta.spring_solo_project.repositories;

import com.bnta.spring_solo_project.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Derived Queries
    List<Patient> findPatientByFirstNameIgnoreCase(String firstName);

    List<Patient> findPatientByLastNameIgnoreCase(String lastName);

    List<Patient> findPatientByAgeGreaterThan(int age);

    List<Patient> findPatientByAgeLessThan(int age);

    List<Patient> findPatientByGenderIgnoreCase(String gender);
}
