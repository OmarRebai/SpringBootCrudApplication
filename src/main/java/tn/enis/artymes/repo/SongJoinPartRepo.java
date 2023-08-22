package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.artymes.model.Part;
import tn.enis.artymes.model.SongJoinPart;

public interface SongJoinPartRepo extends JpaRepository<SongJoinPart,Long> {
}
