package com.vd.event.consumer.infrastructure.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vd.event.consumer.infrastructure.kafka.model.CustomEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;

public class EventDeserializer implements Deserializer<CustomEvent> {

    private final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public CustomEvent deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return MAPPER.readValue(new String(data, StandardCharsets.UTF_8), CustomEvent.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to CustomEvent");
        }
    }
}
