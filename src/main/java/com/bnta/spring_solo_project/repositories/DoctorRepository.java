package com.bnta.spring_solo_project.repositories;

import com.bnta.spring_solo_project.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
