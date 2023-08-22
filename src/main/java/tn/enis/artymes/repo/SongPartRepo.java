package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.artymes.model.SongPart;

import java.util.List;

@Repository
public interface SongPartRepo extends JpaRepository<SongPart, Long> {
    List<SongPart> findAllBySongIdOrderByRank (Long id);
}
