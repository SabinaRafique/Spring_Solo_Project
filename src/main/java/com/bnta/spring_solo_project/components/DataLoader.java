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

        // Add some Medications
        Medication medication1 = new Medication("Paracetamol");
        Medication medication2 = new Medication("Aspirin");
        Medication medication3 = new Medication("Antihistamines");
        Medication medication4 = new Medication("Epi-pen");
        Medication medication5 = new Medication("Anti-depressants");
        Medication medication6 = new Medication("Sleeping Pills");
        Medication medication7 = new Medication("Accutane");
        medicationRepository.saveAll(Arrays.asList(medication1, medication2, medication3, medication4, medication5, medication6, medication7));


        // Add some Doctors
        Doctor doctor1 = new Doctor("Dr Alan Finchley", "Neurosurgeon", Arrays.asList(medication2, medication6));
        Doctor doctor2 = new Doctor("Dr Claire Brown", "Dermatologist", Arrays.asList(medication7));
        Doctor doctor3 = new Doctor("Dr Farah Ali", "GP", Arrays.asList(medication1, medication2,
                medication3, medication4, medication5, medication6));
        Doctor doctor4 = new Doctor("Dr Shaun Murphy", "Psychiatrist", Arrays.asList(medication5, medication6));
        Doctor doctor5 = new Doctor("Dr Michael Peters", "Oncologist", Arrays.asList(medication1, medication2, medication5));
        Doctor doctor6 = new Doctor("Dr Lily Anders", "Obstetrician", Arrays.asList(medication1));
        doctorRepository.saveAll(
                Arrays.asList(doctor1, doctor2, doctor3, doctor4, doctor5, doctor6));


        // Add some Patients
        Patient patient1 = new Patient("Sophia", "Masters", "Female", 23,
                "07788667541", "24 Dreamers Lane", doctor6, Arrays.asList(medication1, medication4));
        Patient patient2 = new Patient("Alan", "Brown", "Male", 20,
                "02085586376", "1 Made Up Avenue", doctor2, Arrays.asList(medication3, medication4, medication7));
        Patient patient3 = new Patient("Lucy", "Greene", "Female", 50,
                "07892341121", "33 Sunnyside Road", doctor2, Arrays.asList(medication1, medication4));
        Patient patient4 = new Patient("Ricky", "Lee", "Male", 80,
                "02083596294", "11 Westminster Avenue", doctor1, Arrays.asList(medication2, medication3));
        Patient patient5 = new Patient("Mark", "Appleby", "Male", 35,
                "07845456744", "15 Apricot Avenue", doctor1, Arrays.asList(medication3, medication6));
        Patient patient6 = new Patient("Hazel", "Smith", "Female", 42,
                "07538492245", "78 Hargrove Road", doctor5, Arrays.asList(medication2, medication3, medication4));
        Patient patient7 = new Patient("Grace", "O'Neil", "Female", 18,
                "07778889990", "43 Fenchurch Street", doctor4, Arrays.asList(medication3, medication4));
        Patient patient8 = new Patient("Brandon", "Masters", "Male", 65,
                "07733220098", "5a Vicarage Road", doctor3, Arrays.asList(medication1, medication3));
        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6, patient7, patient8));


    }
}