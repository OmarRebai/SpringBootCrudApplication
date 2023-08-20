package tn.enis.artymes.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import tn.enis.artymes.model.Client;

import java.io.IOException;

public class ClientSerializer extends StdSerializer<Client> {

	public ClientSerializer() {
		this(null);
	}

	public ClientSerializer(Class<Client> t) {
		super(t);
	}


	@Override
	public void serialize(
			Client client, JsonGenerator generator, SerializerProvider provider
	) throws IOException {

		generator.writeObject(client.getId());
	}
}

