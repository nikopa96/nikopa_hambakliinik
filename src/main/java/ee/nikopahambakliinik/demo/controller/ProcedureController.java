package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Procedure;
import ee.nikopahambakliinik.demo.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public Iterable<Procedure> getAllProcedures() {
        return procedureService.getAllProcedures();
    }

}
