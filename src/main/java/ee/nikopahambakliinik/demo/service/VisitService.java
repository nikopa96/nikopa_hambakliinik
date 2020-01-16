package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Visit;
import ee.nikopahambakliinik.demo.repository.VisitRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    @NonNull
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findByIsBookedFalseOrderByTimeAsc();
    }

    public List<Visit> getAllVisitsOrderByIdDesc() {
        return visitRepository.findAllByOrderByIdDesc();
    }

    public Optional<Visit> getVisitById(Long visitId) {
        return visitRepository.findById(visitId);
    }

    public Visit addVisit(Visit visit) {
        visitRepository.save(visit);
        return visit;
    }

    public Visit updateVisit(Long visitId, Visit newVisit) {
        Optional<Visit> requestedVisit = visitRepository.findById(visitId);

        if (requestedVisit.isPresent()) {
            Visit visit = requestedVisit.get();
            visit.setDoctor(newVisit.getDoctor());
            visit.setProcedure(newVisit.getProcedure());
            visit.setDate(newVisit.getDate());
            visit.setTime(newVisit.getTime());
            visit.setInterval(newVisit.getInterval());
            visit.setIsActive(newVisit.getIsActive());
            visit.setIsBooked(newVisit.getIsBooked());

            return visitRepository.save(visit);
        }

        return null;
    }

    public void deleteVisit(Long visitId) {
        Optional<Visit> requestedVisit = visitRepository.findById(visitId);
        requestedVisit.ifPresent(visit -> visitRepository.deleteById(visit.getId()));
    }
}
