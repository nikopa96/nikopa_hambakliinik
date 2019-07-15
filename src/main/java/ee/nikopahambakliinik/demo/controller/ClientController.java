package ee.nikopahambakliinik.demo.controller;

import ee.nikopahambakliinik.demo.model.Client;
import ee.nikopahambakliinik.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/getall")
    @CrossOrigin
    public Iterable<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "/get/{id}")
    @CrossOrigin
    public Optional<Client> getClientById(@PathVariable("id") @Valid Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping(path = "/add")
    @CrossOrigin
    public Client addClient(@RequestBody @Valid Client client) {
        return clientService.addClient(client);
    }
}
