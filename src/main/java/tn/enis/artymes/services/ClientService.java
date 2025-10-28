package tn.enis.artymes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enis.artymes.model.Client;
import tn.enis.artymes.repo.ClientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService (ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client){
        return clientRepo.save(client);
    }
    public List<Client> findAllClients(){
        return clientRepo.findAll();
    }
    public Optional<Client> findClientById(Long id){
        return clientRepo.findClientById(id);
    }


    public Client updateClient(Client client){
        return clientRepo.save(client);
    }
    @Transactional
    public void deleteClient(Long id){
        clientRepo.deleteClientById(id);
    }
//    public Client findClientById(String id){
//        return clientRepo.findClientById(id).orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
//    }



}