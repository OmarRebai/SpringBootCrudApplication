package tn.enis.artymes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.dto.SongPartDto;
import tn.enis.artymes.dto.SongPartResponseDto;
import tn.enis.artymes.services.SongPartService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/song_parts")
@CrossOrigin("*")
public class SongPartController {


    private final SongPartService songPartService;

    public SongPartController (SongPartService songPartService) {
        this.songPartService = songPartService;
    }

    @PostMapping
    public ResponseEntity<SongPartDto> addPartToSong (@Valid @RequestBody SongPartDto songPartDto) {
        SongPartDto songPart = songPartService.addPartToSong(songPartDto.getSongId(), songPartDto.getPartId(), songPartDto.getRank());
        return new ResponseEntity<>(songPart, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SongPartResponseDto>> getAllSongPartsBySongId (@PathVariable Long id) {
        return new ResponseEntity<>(songPartService.getAllPartsBySongId(id), HttpStatus.OK);
    }

}

//    @GetMapping
//    public ResponseEntity<List<SongPartDto>> getAllSongParts () {
//        return new ResponseEntity<>(songPartService.getAllParts(), HttpStatus.OK);
//    }
