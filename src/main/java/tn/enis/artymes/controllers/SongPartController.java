package tn.enis.artymes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.dto.SongPartDto;
import tn.enis.artymes.model.SongPart;
import tn.enis.artymes.services.SongPartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/song_join_parts")
@CrossOrigin("*")
public class SongPartController {


    @Autowired
    private SongPartService songPartService;

    @PostMapping
    public ResponseEntity<SongPart> addPartToSong (@RequestBody Long songId, @RequestBody Long partId) {
        SongPart songPart = songPartService.addPartToSong(songId, partId);
        return new ResponseEntity<>(songPart, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SongPartDto>> getAllSongParts(){
        return new ResponseEntity<>(songPartService.getAllParts(),HttpStatus.OK);
    }
}
