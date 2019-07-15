package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Client;
import ee.nikopahambakliinik.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    public Optional<Client> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }
}
