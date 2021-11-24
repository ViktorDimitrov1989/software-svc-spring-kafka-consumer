package com.vd.event.consumer

import com.vd.event.consumer.infrastructure.kafka.KafkaEventListener
import nl.altindag.log.LogCaptor
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.kafka.config.KafkaListenerEndpointRegistry
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.listener.MessageListenerContainer
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

import java.nio.charset.StandardCharsets

//TODO: last change
@SpringBootTest
//        (classes = [ KafkaEventListener.class ])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@EmbeddedKafka
//        (
//		partitions = 1,
//		controlledShutdown = false,
//		brokerProperties = ["listeners=PLAINTEXT://localhost:9092", "port=9092" ])
@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

//@ExtendWith(SpringExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

	private static final String COMSUMER_TOPIC = "default_topic"

	@SpyBean
	private KafkaEventListener listener

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry

	@Autowired
	private EmbeddedKafkaBroker embeddedKafkaBroker

	private Producer<String, String> producer


	private void initializeProducer() {
		Map<String, Object> configs = KafkaTestUtils.producerProps(embeddedKafkaBroker);
		producer = new DefaultKafkaProducerFactory<>(
				configs,
				new StringSerializer(),
				new StringSerializer()).createProducer()
	}

	private String readFileAsString(final String filePath) throws URISyntaxException {
		ClassLoader classLoader = this.getClass().getClassLoader()
		new String(new File(classLoader.getResource(filePath).toURI()).getBytes(), StandardCharsets.UTF_8)
	}

	@BeforeEach
	void setUp() {
//		for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
//			ContainerTestUtils.waitForAssignment(messageListenerContainer,
//					kafkaEmbeded.getPartitionsPerTopic());
//		}
		initializeProducer()
	}

	@AfterEach
	void afterEach() {
		producer.close()
	}

	@Test
	void sendEventSuccess() {
		LogCaptor logCaptor = LogCaptor.forRoot()

		producer.send(
				new ProducerRecord<String, String>(
						COMSUMER_TOPIC,
						0,
						"123",
						readFileAsString("deserialize/valid_event.json")))
		producer.flush()
	}

}
