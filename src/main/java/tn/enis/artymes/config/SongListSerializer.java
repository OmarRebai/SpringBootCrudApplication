package tn.enis.artymes.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tn.enis.artymes.dto.SongDto;
import tn.enis.artymes.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongListSerializer extends StdSerializer<List<Song>> {

	@Autowired
	private ModelMapper mapper;

	public SongListSerializer() {
		this(null);
	}

	public SongListSerializer(Class<List<Song>> t) {
		super(t);
	}


	@Override
	public void serialize(
			List<Song> items,
			JsonGenerator generator,
			SerializerProvider provider
	)
			throws IOException {

		List<SongDto> ids = new ArrayList<>();
		for (Song item : items) {
			ids.add(mapper.map(item, SongDto.class));
		}
		generator.writeObject(ids);
	}
}

