package tn.enis.artymes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.model.Client;
import tn.enis.artymes.services.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@CrossOrigin("*")
public class ClientController {
    private final ClientService clientService;

    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello form our API");
    }
    @GetMapping("/goodbye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("Good bye <3");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@Valid @RequestBody Client client){
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client updateClient = clientService.updateClient(client);
        return new ResponseEntity<>(updateClient,HttpStatus.OK);
    }
}
