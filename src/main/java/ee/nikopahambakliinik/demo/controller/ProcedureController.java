package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Procedure;
import ee.nikopahambakliinik.demo.service.ProcedureService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "procedures")
@RequiredArgsConstructor
public class ProcedureController {

    @NonNull
    private ProcedureService procedureService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public List<Procedure> getAllProcedures() {
        return procedureService.getAllProcedures();
    }

}
