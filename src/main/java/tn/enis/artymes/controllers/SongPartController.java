package tn.enis.artymes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.dto.SongPartDto;
import tn.enis.artymes.services.SongPartService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/song_join_parts")
@CrossOrigin("*")
public class SongPartController {


    @Autowired
    private SongPartService songPartService;

    //    @PostMapping
//    public ResponseEntity<SongPart> addPartToSong (@RequestBody Long songId, @RequestBody Long partId) {
//        SongPart songPart = songPartService.addPartToSong(songId, partId);
//        return new ResponseEntity<>(songPart, HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<SongPartDto> addPartToSong (@Valid @RequestBody SongPartDto songPartDto) {
        SongPartDto songPart = songPartService.addPartToSong(songPartDto.getSongId(), songPartDto.getPartId(), songPartDto.getRank());
        return new ResponseEntity<>(songPart, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SongPartDto>> getAllSongParts () {
        return new ResponseEntity<>(songPartService.getAllParts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SongPartDto>> getAllSongPartsBySongId (@PathVariable Long id) {
        return new ResponseEntity<>(songPartService.getAllPartsBySongId(id), HttpStatus.OK);
    }
}
