package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Visit;
import ee.nikopahambakliinik.demo.repository.VisitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitControllerTest {

    @Autowired
    private VisitController visitController;

    @MockBean
    private VisitRepository visitRepository;

    private List<Visit> visits;
    private DateTimeFormatter dateFormat;
    private DateTimeFormatter timeFormat;

    @Before
    public void setUp() {
        this.dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.timeFormat = DateTimeFormatter.ofPattern("HH:mm");

        Visit visit1 = new Visit(3L, null, null, LocalDate.parse("30.07.2019", dateFormat),
                LocalTime.parse("11:00", timeFormat), "11:00 - 12:00", true, false);
        Visit visit2 = new Visit(2L, null, null, LocalDate.parse("30.07.2019", dateFormat),
                LocalTime.parse("16:35", timeFormat), "16:00 - 17:00", true, false);
        Visit visit3 = new Visit(1L, null, null, LocalDate.parse("30.07.2019", dateFormat),
                LocalTime.parse("18:40", timeFormat), "18:00 - 19:00", true, false);

        this.visits = Arrays.asList(visit1, visit2, visit3);
    }

    @Test
    public void getAllVisitsTest() {
        when(visitRepository.findByIsBookedFalseOrderByTimeAsc()).thenReturn(visits);
        assertEquals(3, visitController.getAllVisits().size());
    }

    @Test
    public void getAllVisitsOrderByIdDesc() {
        when(visitRepository.findAllByOrderByIdDesc()).thenReturn(visits);
        assertEquals(3, visitController.getAllVisitsOrderByIdDesc().size());
    }

    @Test
    public void getVisitById() {
        when(visitRepository.findById(2L)).thenReturn(Optional.of(visits.get(1)));
        assertEquals(visits.get(1), visitController.getVisitById(2L).orElse(null));

        when(visitRepository.findById(5L)).thenReturn(Optional.empty());
        assertNull(visitController.getVisitById(5L).orElse(null));
    }

    @Test
    public void addVisit() {
        Visit newVisit = new Visit(5L, null, null, LocalDate.parse("30.07.2019", dateFormat),
                LocalTime.parse("18:15", timeFormat), "18:00 - 19:00", true, false);
        Visit savedVisit = visitController.addVisit(newVisit);

        verify(visitRepository, times(1)).save(newVisit);
        assertEquals(newVisit, savedVisit);
    }

    @Test
    public void updateVisit() {
        Visit oldVisit = visits.get(0);
        Visit newVisit = new Visit(3L, null, null, LocalDate.parse("30.07.2019", dateFormat),
                LocalTime.parse("16:30", timeFormat), "16:00 - 17:00", true, true);

        when(visitRepository.findById(3L)).thenReturn(Optional.of(oldVisit));
        Visit updatedVisit = visitController.updateVisit(3L, newVisit);

        verify(visitRepository, times(1)).save(oldVisit);
        assertNotEquals(oldVisit, updatedVisit);
    }

    @Test
    public void deleteVisit() {
        Visit visit = visits.get(0);

        when(visitRepository.findById(3L)).thenReturn(Optional.of(visit));
        visitController.deleteVisit(3L);

        verify(visitRepository, times(1)).deleteById(3L);
    }
}