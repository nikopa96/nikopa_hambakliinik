package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Procedure;
import ee.nikopahambakliinik.demo.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    public Iterable<Procedure> getAllProcedures() {
        return procedureRepository.findAll();
    }
}
