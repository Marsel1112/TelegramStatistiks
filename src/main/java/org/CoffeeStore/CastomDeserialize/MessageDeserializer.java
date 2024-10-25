package org.CoffeeStore.CastomDeserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.CoffeeStore.Entity.Message;
import org.CoffeeStore.Entity.TextEntities;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MessageDeserializer extends JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        Message message = new Message();

        message.setId(node.get("id").asInt());
        message.setType(node.get("type").asText());
        message.setDate(LocalDateTime.parse(node.get("date").asText()));
        if(node.get("from") != null) {
            message.setFrom(node.get("from").asText());
        }
        if(node.get("from_id") != null) {
            message.setFrom_id(node.get("from_id").asText());
        }

        message.setText(node.get("text").asText());
        return message;
    }
}
