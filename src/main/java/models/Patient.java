package models;

import java.time.LocalDate;
import java.util.List;

public class Patient {

    private Long id;
    private String name;
    private String gender;
    private LocalDate dob;
    private String phoneNumber;
    private String address;

    private Doctor doctor;

    private List<Medicine> medicineList;

}
