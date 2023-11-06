package tn.enis.artymes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "song")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String beatUrl;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToMany(mappedBy = "song")
	@JsonIgnore
	private List<Part> parts = new ArrayList<>();

//	public Song(Long id, String title, String beatUrl, Client client) {
//		this.id = id;
//		this.title = title;
//		this.beatUrl = beatUrl;
//		this.client = client;
//	}
}
