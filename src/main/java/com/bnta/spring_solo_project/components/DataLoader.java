package com.bnta.spring_solo_project.components;

import com.bnta.spring_solo_project.models.Doctor;
import com.bnta.spring_solo_project.models.Medication;
import com.bnta.spring_solo_project.models.Patient;
import com.bnta.spring_solo_project.repositories.DoctorRepository;
import com.bnta.spring_solo_project.repositories.MedicationRepository;
import com.bnta.spring_solo_project.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

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


        // Add some Doctors
        Doctor doctor1 = new Doctor("Dr Alan Finchley", "Neurosurgeon");
        Doctor doctor2 = new Doctor("Dr Claire Brown", "Dermatologist");
        Doctor doctor3 = new Doctor("Dr Farah Ali", "GP");
        Doctor doctor4 = new Doctor("Dr Shaun Murphy", "Psychiatrist");
        Doctor doctor5 = new Doctor("Dr Michael Peters", "Oncologist");
        Doctor doctor6 = new Doctor("Dr Lily Anders", "Obstetrician");
        doctorRepository.saveAll(
                Arrays.asList(doctor1, doctor2, doctor3, doctor4, doctor5, doctor6));

        // Add some Medications
        Medication medication1 = new Medication("Paracetamol");
        Medication medication2 = new Medication("Aspirin");
        Medication medication3 = new Medication("Antihistamines");
        Medication medication4 = new Medication("Epi-pen");
        medicationRepository.saveAll(Arrays.asList(medication1, medication2, medication3, medication4));


        // Add some Patients
        Patient patient1 = new Patient("Sophia Masters", "Female", LocalDate.of(1995, 3, 3),
                "07788667541", "24 Dreamers Lane", doctor6, Arrays.asList(medication1, medication2));
        Patient patient2 = new Patient("Alan Brown", "Male", LocalDate.of(2000, 1, 1),
                "02085586376", "1 Made Up Avenue", doctor2, Arrays.asList(medication3, medication4));
        Patient patient3 = new Patient("Lucy Greene", "Female", LocalDate.of(2002, 5, 5),
                "07892341121", "33 Sunnyside Road", doctor2, Arrays.asList(medication1, medication4));
        Patient patient4 = new Patient("Ricky Lee", "Male", LocalDate.of(1950, 2, 25),
                "02083596294", "11 Westminster Avenue", doctor1, Arrays.asList(medication2, medication3));
        Patient patient5 = new Patient("Mark Appleby", "Male", LocalDate.of(1965, 8, 2),
                "07845456744", "15 Apricot Avenue", doctor1, Arrays.asList(medication1, medication3));
        Patient patient6 = new Patient("Hazel Smith", "Female", LocalDate.of(1988, 8, 8),
                "07538492245", "78 Hargrove Road", doctor5, Arrays.asList(medication2, medication3, medication4));
        Patient patient7 = new Patient("Grace O'Neil", "Female", LocalDate.of(2000, 10, 31),
                "07778889990", "43 Fenchurch Street", doctor4, Arrays.asList(medication2, medication4));
        Patient patient8 = new Patient("Brandon McKormick", "Male", LocalDate.of(1975, 11, 12),
                "07733220098", "5a Vicarage Road", doctor3, Arrays.asList(medication2, medication3));
        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6, patient7, patient8));



    }
}