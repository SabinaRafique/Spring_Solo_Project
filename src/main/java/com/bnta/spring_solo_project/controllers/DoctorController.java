package com.bnta.spring_solo_project.controllers;

import com.bnta.spring_solo_project.models.Doctor;
import com.bnta.spring_solo_project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    // INDEX - tested on Postman
//    @GetMapping // localhost:8080/doctors
//    public ResponseEntity<List<Doctor>> getDoctors() {
//        return new ResponseEntity<>(doctorRepository.findAll(), HttpStatus.OK);
//    }


    // INDEX AND FILTERS
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctorsAndFilters(
            @RequestParam(required = false, name = "speciality") String speciality
    ){
        if(speciality != null){
            return new ResponseEntity<>(doctorRepository.findDoctorBySpecialityIgnoreCase(speciality), HttpStatus.OK);
        }
        else
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
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor newDoctor) {
        doctorRepository.save(newDoctor);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    } // Functional POST request - can add items through Postman


    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/doctors/1 (or any other id number instead of 1)
    public ResponseEntity<Long> deleteDoctor(@PathVariable("id") Long id) {
        doctorRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}