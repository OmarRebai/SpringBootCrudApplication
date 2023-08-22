package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.artymes.model.Part;


public interface PartRepo extends JpaRepository<Part, Long> {
}
