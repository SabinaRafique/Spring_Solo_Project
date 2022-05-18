package com.bnta.spring_solo_project.components;

import com.bnta.spring_solo_project.repositories.DoctorRepository;
import com.bnta.spring_solo_project.repositories.MedicationRepository;
import com.bnta.spring_solo_project.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}