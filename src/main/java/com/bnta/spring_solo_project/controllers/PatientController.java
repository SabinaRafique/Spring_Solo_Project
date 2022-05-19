package com.bnta.spring_solo_project.controllers;

import com.bnta.spring_solo_project.models.Medication;
import com.bnta.spring_solo_project.models.Patient;
import com.bnta.spring_solo_project.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    // INDEX - tested on Postman
    @GetMapping // localhost:8080/patients
    public ResponseEntity<List<Patient>> getPatients() {
        return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/patients/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Patient>> getPatients(@PathVariable Long id) {
        var product = patientRepository.findById(id);
        // Ternary Operator: condition ? true statement : false statement
        return new ResponseEntity<>(product, product.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping // POST localhost:8080/patients
    public ResponseEntity<Patient> createPatient(@RequestBody Patient newPatient) {
        patientRepository.save(newPatient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    } // Functional POST request - can add items through Postman


    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/patients/1 (or any other id number instead of 1)
    public ResponseEntity<Long> deletePatient (@PathVariable("id") Long id) {
        patientRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
