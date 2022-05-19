package com.bnta.spring_solo_project;

import com.bnta.spring_solo_project.models.Doctor;
import com.bnta.spring_solo_project.models.Medication;
import com.bnta.spring_solo_project.models.Patient;
import com.bnta.spring_solo_project.repositories.DoctorRepository;
import com.bnta.spring_solo_project.repositories.MedicationRepository;
import com.bnta.spring_solo_project.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringSoloProjectApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	MedicationRepository medicationRepository;

	@Test
	void contextLoads() {
	}

	//------------------------------ Derived Query Tests for Doctor -------------------------------\\
	@Test
	public void canFindGPsInDoctors() {
		List<Doctor> found = doctorRepository.findDoctorBySpecialityIgnoreCase("gp");
		assertThat(found.size()).isEqualTo(1);
	}


	//------------------------------ Derived Query Tests for Patient -------------------------------\\
	@Test
	public void canFindPatientsWithFirstNameRicky() {
		List<Patient> found = patientRepository.findPatientByFirstNameIgnoreCase("ricky");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindPatientsWithLastNameMasters() {
		List<Patient> found = patientRepository.findPatientByLastNameIgnoreCase("masters");
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	public void canFindPatientsOlderThan30 () {
		List<Patient> found = patientRepository.findPatientByAgeGreaterThan(30);
		assertThat(found.size()).isEqualTo(5);
	}

	@Test
	public void canFindPatientYoungerThan30() {
		List<Patient> found = patientRepository.findPatientByAgeLessThan(30);
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindAllFemalePatients () {
		List<Patient> found = patientRepository.findPatientByGenderIgnoreCase("female");
		assertThat(found.size()).isEqualTo(4);
	}

	//------------------------------ Derived Query Tests for Medication -------------------------------\\
	@Test
	public void canFindMedicationByNameAspirin () {
		List<Medication> found = medicationRepository.findMedicationByNameIgnoreCase("aspirin");
		assertThat(found.size()).isEqualTo(1);
	}


}
