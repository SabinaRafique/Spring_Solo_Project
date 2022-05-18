package com.bnta.spring_solo_project.controllers;

import com.bnta.spring_solo_project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

}
