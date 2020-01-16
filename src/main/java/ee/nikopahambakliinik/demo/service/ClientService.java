package ee.nikopahambakliinik.demo.service;

import ee.nikopahambakliinik.demo.model.Client;
import ee.nikopahambakliinik.demo.repository.ClientRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    @NonNull
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    public Client addClient(Client client) {
        clientRepository.save(client);
        return client;
    }
}
