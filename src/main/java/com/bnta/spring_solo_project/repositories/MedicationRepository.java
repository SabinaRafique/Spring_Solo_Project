package com.bnta.spring_solo_project.repositories;

import com.bnta.spring_solo_project.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
