package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Visit;
import ee.nikopahambakliinik.demo.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public Iterable<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping(path = "/getallbyid")
    @CrossOrigin
    public Iterable<Visit> getAllVisitsOrderById() {
        return visitService.getAllVisitsOrderById();
    }

    @GetMapping(path = "get/{id}")
    @CrossOrigin
    public Optional<Visit> getVisitById(@PathVariable("id") Long id) {
        return visitService.getVisitById(id);
    }

    @PostMapping(path = "add")
    @CrossOrigin
    public Visit addVisit(@RequestBody Visit visit) {
        return visitService.addVisit(visit);
    }

    @PutMapping(path = "update/{id}")
    @CrossOrigin
    public void updateVisit(@PathVariable("id") Long id, @RequestBody Visit visit) {
        visitService.updateVisit(id, visit);
    }

    @DeleteMapping(path = "delete/{id}")
    @CrossOrigin
    public void deleteVisit(@PathVariable("id") Long id) {
        visitService.deleteVisit(id);
    }

}
