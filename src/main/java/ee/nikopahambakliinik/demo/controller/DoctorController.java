package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Doctor;
import ee.nikopahambakliinik.demo.service.DoctorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "doctors")
@RequiredArgsConstructor
public class DoctorController {

    @NonNull
    private DoctorService doctorService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

}
