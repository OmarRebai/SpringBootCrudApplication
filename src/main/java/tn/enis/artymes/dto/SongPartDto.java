package tn.enis.artymes.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SongPartDto {
    private Long id;
    private Long songId;
    private Long partId;
    private int rank;
}
