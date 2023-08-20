package tn.enis.artymes.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.artymes.model.Part;
import tn.enis.artymes.repo.PartRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    private final PartRepo partRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public PartService (PartRepo partRepo, ModelMapper modelMapper) {
        this.partRepo = partRepo;
        this.modelMapper = modelMapper;
    }

    public Part createPart (Part part) {
        return partRepo.save(part);
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
}
