package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Procedure;
import ee.nikopahambakliinik.demo.repository.ProcedureRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureService {

    @NonNull
    private ProcedureRepository procedureRepository;

    public List<Procedure> getAllProcedures() {
        return procedureRepository.findAll();
    }
}
