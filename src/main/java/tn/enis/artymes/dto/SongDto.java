package tn.enis.artymes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDto {
    private Long id;
    private String title;
    private String beatUrl;
    private Long clientId;
}
