package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Client;
import ee.nikopahambakliinik.demo.repository.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

    @Autowired
    private ClientController clientController;

    @MockBean
    private ClientRepository clientRepository;

    private List<Client> clients;

    @Before
    public void setUp() {
        Client client1 = new Client(1L, 1L, "Frances", "Slater",
                "+372 875 0917", "frances@mail.eu", "EMAIL");
        Client client2 = new Client(2L, 2L, "Buddy", "Schofield",
                "+372 909 8554", "buddy@mail.eu", "PHONE");

        this.clients = Arrays.asList(client1, client2);
    }

    @Test
    public void getAllClientsTest() {
        when(clientRepository.findAll()).thenReturn(clients);
        assertEquals(2, clientController.getAllClients().size());
    }

    @Test
    public void getClientByIdTest() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(clients.get(0)));
        assertEquals(clients.get(0), clientController.getClientById(1L).orElse(null));

        when(clientRepository.findById(3L)).thenReturn(Optional.empty());
        assertNull(clientController.getClientById(3L).orElse(null));
    }

    @Test
    public void addClient() {
        Client newClient = new Client(3L, 3L, "John", "Doe", "+372 541 4480",
                "john@mail.eu", "PHONE");
        Client savedClient = clientController.addClient(newClient);

        when(clientRepository.save(newClient)).thenReturn(savedClient);

        verify(clientRepository, times(1)).save(newClient);
        assertEquals(newClient, savedClient);
    }
}