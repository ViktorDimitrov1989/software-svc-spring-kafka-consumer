package com.vd.event.consumer.infrastructure.kafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Getter
public class CustomEvent {

    private Map<String, Object> header;

    private Map<String, Object> payload;
}
