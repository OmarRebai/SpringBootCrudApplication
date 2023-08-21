package tn.enis.artymes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.dto.SongDto;
import tn.enis.artymes.services.SongService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/song")
@CrossOrigin("*")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController (SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<SongDto> addSong (@Valid @RequestBody SongDto songDto) {
        SongDto newSong = songService.createSong(songDto);
        return new ResponseEntity<>(newSong, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SongDto>> getAllSongs () {
        List<SongDto> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SongDto> getSongById (@PathVariable Long id) {
        Optional<SongDto> songOptional = songService.getSongById(id);
        return songOptional.map(song -> new ResponseEntity<>(song, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong (@PathVariable Long id) {
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/entities")
    public ResponseEntity<List<SongDto>> getAllSongEntities () {
		return ResponseEntity.ok(songService.getAllSongsEntities());
    }
}
