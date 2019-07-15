package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Visit;
import ee.nikopahambakliinik.demo.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Iterable<Visit> getAllVisits() {
        return visitRepository.findByIsBookedFalseOrderByTimeAsc();
    }

    public Iterable<Visit> getAllVisitsOrderById() {
        return visitRepository.findAllByOrderByIdDesc();
    }

    public Optional<Visit> getVisitById(Long visitId) {
        return visitRepository.findById(visitId);
    }

    public Visit addVisit(Visit visit) {
        visitRepository.save(visit);
        return visit;
    }

    public void updateVisit(Long visitId, Visit newVisit) {
        Optional<Visit> requestedVisit = visitRepository.findById(visitId);

        if (requestedVisit.isPresent()) {
            Visit visit = requestedVisit.get();
            visit.setDoctor(newVisit.getDoctor());
            visit.setProcedure(newVisit.getProcedure());
            visit.setTime(newVisit.getTime());
            visit.setIsActive(newVisit.getIsActive());
            visit.setIsBooked(newVisit.getIsBooked());

            visitRepository.save(visit);
        }
    }

    public void deleteVisit(Long visitId) {
        Optional<Visit> requestedVisit = visitRepository.findById(visitId);
        requestedVisit.ifPresent(visit -> visitRepository.deleteById(visit.getId()));
    }
}
