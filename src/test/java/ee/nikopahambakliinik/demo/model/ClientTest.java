package ee.nikopahambakliinik.demo.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void shouldNotAcceptNullsOrEmptyStrings() {
        Client client1 = new Client(1L, null, null, null, null, null,
                null);
        Client client2 = new Client(1L, 1L, "", "", "", "test@mail.eu",
                "");
        Client client3 = new Client(1L, 2L, "John", "Doe", "(+372)66800981",
                "john@mail.com", "PHONE");
        Set<ConstraintViolation<Client>> violations1 = validator.validate(client1);
        Set<ConstraintViolation<Client>> violations2 = validator.validate(client2);
        Set<ConstraintViolation<Client>> violations3 = validator.validate(client3);

        assertEquals(6, violations1.size());
        assertEquals(4, violations2.size());
        assertEquals(0, violations3.size());
    }

    @Test
    public void shouldNotAcceptWrongPatterns() {
        Client client1 = new Client(1L, 2L, "John", "Doe", "55067ab1",
                "john^mail.com", "PHONE");
        Client client2 = new Client(1L, 2L, "John", "Doe", "(+372) 66800981",
                "john@mail.com", "PHONE");
        Set<ConstraintViolation<Client>> violations1 = validator.validate(client1);
        Set<ConstraintViolation<Client>> violations2 = validator.validate(client2);

        assertEquals(2, violations1.size());
        assertEquals(0, violations2.size());
    }

    @Test
    public void shouldNotAcceptWrongMaxSize() {
        Client client = new Client(1L, 2L, "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                "elit. Nunc at porta erat. Quisque elit lectus, iaculis sit amet hendrerit vel, blandit in quam. " +
                "Sed sit amet nisl libero. Donec finibus imperdiet tortor ut cursus. Integer mauris nibh, molestie " +
                "ac posuere.", "Doe", "6680098166800981668009816680098166800981668009816680098198" +
                "1668009819816680098198166800981", "john@mail.com", "PHONEPHONE");
        Set<ConstraintViolation<Client>> violations = validator.validate(client);

        assertEquals(3, violations.size());
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }
}