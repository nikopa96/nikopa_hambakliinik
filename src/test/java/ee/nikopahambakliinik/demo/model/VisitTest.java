package ee.nikopahambakliinik.demo.model;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitTest {

    private DateTimeFormatter dateFormat;
    private DateTimeFormatter timeFormat;
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @Before
    public void setUp() {
        this.dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    }

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void shouldNotAcceptNullsOrEmptyStrings() {
        Visit visit1 = new Visit(3L, null, null, null, null, null,
                null, null);
        Visit visit2 = new Visit(2L, null, null, null, null, "",
                true, false);
        Visit visit3 = new Visit(1L, null, null, LocalDate.parse("30.07.2019", dateFormat),
                LocalTime.parse("18:40", timeFormat), "18:00 - 19:00", true, false);

        Set<ConstraintViolation<Visit>> violations1 = validator.validate(visit1);
        Set<ConstraintViolation<Visit>> violations2 = validator.validate(visit2);
        Set<ConstraintViolation<Visit>> violations3 = validator.validate(visit3);

        assertEquals(5, violations1.size());
        assertEquals(3, violations2.size());
        assertEquals(0, violations3.size());
    }

    @Test
    public void shouldNotAcceptWrongPatterns() {
        LocalDate date = LocalDate.parse("30.07.2019", dateFormat);
        LocalTime time = LocalTime.parse("18:40", timeFormat);

        Visit visit1 = new Visit(1L, null, null, date, time, "18:00-19:00",
                true, false);
        Visit visit2 = new Visit(2L, null, null, date, time, "18:00 - 49:00",
                true, false);
        Visit visit3 = new Visit(3L, null, null, date, time, "58:00 - 19:00",
                true, false);
        Visit visit4 = new Visit(4L, null, null, date, time, "18:00 - 19:00",
                true, false);


        Set<ConstraintViolation<Visit>> violations1 = validator.validate(visit1);
        Set<ConstraintViolation<Visit>> violations2 = validator.validate(visit2);
        Set<ConstraintViolation<Visit>> violations3 = validator.validate(visit3);
        Set<ConstraintViolation<Visit>> violations4 = validator.validate(visit4);

        assertEquals(1, violations1.size());
        assertEquals(1, violations2.size());
        assertEquals(1, violations3.size());
        assertEquals(0, violations4.size());
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }
}