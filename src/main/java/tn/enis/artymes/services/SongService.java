package tn.enis.artymes.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.artymes.dto.SongDto;
import tn.enis.artymes.model.Client;
import tn.enis.artymes.model.Song;
import tn.enis.artymes.repo.ClientRepo;
import tn.enis.artymes.repo.SongRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final SongRepo songRepository;
    private final ModelMapper modelMapper;
    private final ClientRepo clientRepository;

    @Autowired
    public SongService (SongRepo songRepository, ModelMapper modelMapper, ClientRepo clientRepository) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
    }

    public SongDto createSong (SongDto songDto) {
        Song song = convertToEntity(songDto);
        song = songRepository.save(song);
        return convertToDto(song);
    }

    public List<SongDto> getAllSongs () {
        List<Song> songs = songRepository.findAll();
        return songs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<SongDto> getSongById (Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        return songOptional.map(this::convertToDto);
    }

    public void deleteSong (Long id) {
        songRepository.deleteById(id);
    }

    private SongDto convertToDto (Song song) {
        SongDto convertedSong=modelMapper.map(song, SongDto.class);
        convertedSong.setClientId(song.getClient().getId());
        return convertedSong;
    }


    private Song convertToEntity (SongDto songDto) {
        Song song = modelMapper.map(songDto, Song.class);

        if (songDto.getClientId() != null) {
            Client client = clientRepository.findById(songDto.getClientId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));
            song.setClient(client);
        }

        return song;
    }
}
