package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Doctor;
import ee.nikopahambakliinik.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public Iterable<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

}
