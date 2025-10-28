package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.artymes.model.Bar;

public interface BarRepo extends JpaRepository<Bar,Long> {
    Bar[] findAllBarsByPartIdOrderByRankAsc (Long part_id);
}
