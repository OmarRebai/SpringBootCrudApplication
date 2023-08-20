package tn.enis.artymes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.artymes.model.Bar;
import tn.enis.artymes.model.Song;

public interface SongRepo extends JpaRepository<Song,Long> {
}
