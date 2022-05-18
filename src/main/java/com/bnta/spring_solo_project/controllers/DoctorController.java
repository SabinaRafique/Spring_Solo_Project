package com.bnta.spring_solo_project.controllers;

import com.bnta.spring_solo_project.models.Doctor;
import com.bnta.spring_solo_project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    // INDEX - tested on Postman
    @GetMapping // localhost:8080/doctors
    public ResponseEntity<List<Doctor>> getDoctors() {
        return new ResponseEntity<>(doctorRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/doctors/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Doctor>> getDoctors(@PathVariable Long id) {
        var product = doctorRepository.findById(id);
        // Ternary Operator: condition ? true statement : false statement
        return new ResponseEntity<>(product, product.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping // localhost:8080/doctors
    public void createDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }
    // Functional POST request - can add items through Postman
}