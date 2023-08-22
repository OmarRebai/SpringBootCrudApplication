package tn.enis.artymes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.artymes.model.Part;
import tn.enis.artymes.model.Song;
import tn.enis.artymes.model.SongJoinPart;
import tn.enis.artymes.repo.PartRepo;
import tn.enis.artymes.repo.SongJoinPartRepo;
import tn.enis.artymes.repo.SongRepo;

import javax.persistence.EntityNotFoundException;

@Service

public class SongJoinPartService {


    @Autowired
    private SongRepo songRepository;

    @Autowired
    private PartRepo partRepository;

    @Autowired
    private SongJoinPartRepo songPartRepository;

    public void addPartToSong(Long songId, Long partId) {
        Song song = songRepository.findById(songId).orElseThrow(() -> new EntityNotFoundException("Song not found"));
        Part part = partRepository.findById(partId).orElseThrow(() -> new EntityNotFoundException("Part not found"));

        SongJoinPart songJoinPart = new SongJoinPart();
        songJoinPart.setSong(song);
        songJoinPart.setPart(part);

        songPartRepository.save(songJoinPart);
    }

    // Other methods to manage Song, Part, and SongPart entities
}
