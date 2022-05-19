package com.bnta.spring_solo_project.repositories;

import com.bnta.spring_solo_project.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    // Derived Query
    List<Medication> findMedicationByNameIgnoreCase(String name);

}
