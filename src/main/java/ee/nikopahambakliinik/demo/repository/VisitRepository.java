package ee.nikopahambakliinik.demo.repository;

import ee.nikopahambakliinik.demo.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    public List<Visit> findByIsBookedFalseOrderByTimeAsc();

    public List<Visit> findAllByOrderByIdDesc();
}
