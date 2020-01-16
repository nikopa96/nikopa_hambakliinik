package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Doctor;
import ee.nikopahambakliinik.demo.repository.DoctorRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    @NonNull
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

}
