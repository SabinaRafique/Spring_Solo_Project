package com.bnta.spring_solo_project.controllers;

import com.bnta.spring_solo_project.models.Doctor;
import com.bnta.spring_solo_project.models.Medication;
import com.bnta.spring_solo_project.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medications")
public class MedicationController {

    @Autowired
    MedicationRepository medicationRepository;

    // INDEX - tested on Postman
    @GetMapping
    public ResponseEntity<List<Medication>> getMedications() {
        return new ResponseEntity<>(medicationRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/medications/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Medication>> getMedications(@PathVariable Long id) {
        var product = medicationRepository.findById(id);
        // Ternary Operator: condition ? true statement : false statement
        return new ResponseEntity<>(product, product.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
}
