package tn.enis.artymes.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.artymes.dto.PartDto;
import tn.enis.artymes.model.Part;
import tn.enis.artymes.model.Song;
import tn.enis.artymes.repo.PartRepo;
import tn.enis.artymes.repo.SongRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    private final PartRepo partRepo;
    private final SongRepo songRepo;
    private final ModelMapper modelMapper;

    @Autowired

    public PartService (PartRepo partRepo, SongRepo songRepo, ModelMapper modelMapper) {
        this.partRepo = partRepo;
        this.songRepo = songRepo;
        this.modelMapper = modelMapper;
    }

    public PartDto createPart (PartDto partDto) {
        return convertToDto(partRepo.save(convertToEntity(partDto)));
    }

    public List<Part> getAllParts () {
        return partRepo.findAll();
    }


    public Optional<Part> getPartById (Long id) {
        return partRepo.findById(id);
    }

    public void deletePart (Long id) {
        partRepo.deleteById(id);
    }

    private PartDto convertToDto (Part part) {
        PartDto convertedPart = modelMapper.map(part, PartDto.class);
        convertedPart.setSongId(part.getSong().getId());
        return convertedPart;
    }


    private Part convertToEntity (PartDto partDto) {
        Part part = modelMapper.map(partDto, Part.class);

        if (partDto.getSongId() != null) {
            Song song = songRepo.findById(partDto.getSongId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));
            part.setSong(song);
        }

        return part;
    }


}
