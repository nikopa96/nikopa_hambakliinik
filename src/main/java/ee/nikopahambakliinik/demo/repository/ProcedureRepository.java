package ee.nikopahambakliinik.demo.repository;

import ee.nikopahambakliinik.demo.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}
