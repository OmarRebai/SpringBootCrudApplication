package tn.enis.artymes.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongPartDto {
    private Long id;
    private Long songId;
    private Long partId;
    private Long rank;
}
