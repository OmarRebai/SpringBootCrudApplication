package tn.enis.artymes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.dto.PartDto;
import tn.enis.artymes.model.Part;
import tn.enis.artymes.services.PartService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/parts")
@CrossOrigin("*")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController (PartService partService) {
        this.partService = partService;
    }


    @PostMapping
    public ResponseEntity<PartDto> addPart(@Valid @RequestBody PartDto partDto) {
        PartDto newPartDto = partService.createPart(partDto);
        return new ResponseEntity<>(newPartDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Part>> getAllParts() {
        List<Part> parts = partService.getAllParts();
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }




    @GetMapping("/{id}")
    public ResponseEntity<Part> getSongById(@PathVariable Long id) {
        Optional<Part> partOptional = partService.getPartById(id);
        return partOptional.map(song -> new ResponseEntity<>(song, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        partService.deletePart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
