package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Visit;
import ee.nikopahambakliinik.demo.service.VisitService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "visits")
@RequiredArgsConstructor
public class VisitController {

    @NonNull
    private VisitService visitService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public List<Visit> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping(path = "/getallbyid")
    @CrossOrigin
    public List<Visit> getAllVisitsOrderByIdDesc() {
        return visitService.getAllVisitsOrderByIdDesc();
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
    public Visit updateVisit(@PathVariable("id") Long id, @RequestBody Visit visit) {
        return visitService.updateVisit(id, visit);
    }

    @DeleteMapping(path = "delete/{id}")
    @CrossOrigin
    public void deleteVisit(@PathVariable("id") Long id) {
        visitService.deleteVisit(id);
    }
}
