package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Doctor;
import ee.nikopahambakliinik.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Iterable<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

}
