package com.bnta.spring_solo_project.repositories;

import com.bnta.spring_solo_project.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Derived Query
    List<Doctor> findDoctorBySpecialityIgnoreCase(String speciality);

}
