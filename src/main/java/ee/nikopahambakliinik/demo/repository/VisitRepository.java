package ee.nikopahambakliinik.demo.repository;

import ee.nikopahambakliinik.demo.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    public Iterable<Visit> findByIsBookedFalseOrderByTimeAsc();

    public Iterable<Visit> findAllByOrderByIdDesc();
}
