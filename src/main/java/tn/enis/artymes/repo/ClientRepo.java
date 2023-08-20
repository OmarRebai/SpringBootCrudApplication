package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.artymes.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Long> {
    Optional<Client> findClientById (Long id);
    List<Client> findClientByOrderByName ();

    void deleteClientById (Long id);
}