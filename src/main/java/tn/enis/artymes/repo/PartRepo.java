package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.artymes.model.Part;

import java.util.List;


public interface PartRepo extends JpaRepository<Part, Long> {
    List<Part> findAllBySongId (Long id);
}
