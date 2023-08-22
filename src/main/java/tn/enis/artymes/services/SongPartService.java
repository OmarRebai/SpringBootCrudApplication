package tn.enis.artymes.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.artymes.dto.SongPartDto;
import tn.enis.artymes.model.Part;
import tn.enis.artymes.model.Song;
import tn.enis.artymes.model.SongPart;
import tn.enis.artymes.repo.PartRepo;
import tn.enis.artymes.repo.SongPartRepo;
import tn.enis.artymes.repo.SongRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class SongPartService {


    private final SongRepo songRepository;

    private final PartRepo partRepository;

    private final SongPartRepo songPartRepository;
    private final ModelMapper modelMapper;

    @Autowired

    public SongPartService (SongRepo songRepository, PartRepo partRepository, SongPartRepo songPartRepository, ModelMapper modelMapper) {
        this.songRepository = songRepository;
        this.partRepository = partRepository;
        this.songPartRepository = songPartRepository;
        this.modelMapper = modelMapper;
    }

    public List<SongPartDto> getAllParts () {
        List<SongPart> songParts = songPartRepository.findAll();
        return songParts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<SongPartDto> getAllPartsBySongId (Long songId) {
        List<SongPart> songParts = songPartRepository.findAllBySongIdOrderByRank(songId);
        return songParts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private SongPartDto convertToDto (SongPart songPart) {
        SongPartDto convertedSongPart = modelMapper.map(songPart, SongPartDto.class);
        convertedSongPart.setSongId(songPart.getSong().getId());
        return convertedSongPart;
    }

    public SongPartDto addPartToSong (Long songId, Long partId, Long rank) {
        Song song = songRepository.findById(songId).orElseThrow(() -> new EntityNotFoundException("Song not found"));
        Part part = partRepository.findById(partId).orElseThrow(() -> new EntityNotFoundException("Part not found"));

        SongPart songPart = new SongPart();
        songPart.setSong(song);
        songPart.setPart(part);
        songPart.setRank(rank);

        return convertToDto(songPartRepository.save(songPart));
    }


}
