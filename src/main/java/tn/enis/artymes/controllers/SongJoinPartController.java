package tn.enis.artymes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enis.artymes.services.SongJoinPartService;

@RestController
@RequestMapping("/api/v1/song_join_parts")
@CrossOrigin("*")
public class SongJoinPartController {


    @Autowired
    private SongJoinPartService songPartService;

    @PostMapping("/addPartToSong")
    public ResponseEntity<String> addPartToSong(@RequestParam Long songId, @RequestParam Long partId) {
        songPartService.addPartToSong(songId, partId);
        return ResponseEntity.ok("Part added to song successfully");
    }

    // Other controller methods for managing Song, Part, and SongPart entities
}
