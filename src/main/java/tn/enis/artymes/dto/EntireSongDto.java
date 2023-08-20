package tn.enis.artymes.dto;

import tn.enis.artymes.model.Client;
import tn.enis.artymes.model.Part;
import java.util.ArrayList;
import java.util.List;

public class EntireSongDto {
    private Long id;
    private String title;
    private String beatUrl;
    private Client client;
    private List<Part> parts = new ArrayList<>();
}
