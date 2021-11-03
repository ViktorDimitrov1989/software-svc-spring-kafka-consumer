package com.vd.event.consumer;

import com.vd.event.consumer.infrastructure.kafka.KafkaEventListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;

@EmbeddedKafka
@SpringBootTest
class ApplicationTests {

	@Autowired
	private KafkaEventListener listener;

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;


	private EmbeddedKafkaBroker embeddedKafkaBroker;

	@BeforeEach
	void setUp(EmbeddedKafkaBroker embeddedKafkaBroker) {
		this.embeddedKafkaBroker = embeddedKafkaBroker;
	}

	@Test
	void contextLoads() {
	}

}
