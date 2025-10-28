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

@RestController
@RequestMapping("/api/v1/parts")
@CrossOrigin("*")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController (PartService partService) {
        this.partService = partService;
    }

    @GetMapping("song/{id}")
    public ResponseEntity<List<PartDto>> getAllPartsBySongId(@PathVariable Long id) {
        List<PartDto> parts = partService.getPartBySongId(id);
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Part> createPart(@Valid @RequestBody PartDto partDto) {
        Part newPartDto = partService.createPart(partDto);
        return new ResponseEntity<>(newPartDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart(@PathVariable Long id) {
        partService.deletePart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

//    @GetMapping
//    public ResponseEntity<List<Part>> getAllParts() {
//        List<Part> parts = partService.getAllParts();
//        return new ResponseEntity<>(parts, HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
//        Optional<Part> partOptional = partService.getPartById(id);
//        return partOptional.map(song -> new ResponseEntity<>(song, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }