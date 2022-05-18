package com.bnta.spring_solo_project.repositories;

import com.bnta.spring_solo_project.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
