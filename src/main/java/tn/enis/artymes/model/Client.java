package tn.enis.artymes.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String cin;
    private String phone;
    private String imageUrl;

    @OneToMany(mappedBy = "client")
    private List<Song> songs = new ArrayList<>();

}

