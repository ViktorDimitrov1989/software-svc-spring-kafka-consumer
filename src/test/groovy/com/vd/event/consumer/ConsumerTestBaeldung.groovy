package com.vd.event.consumer

import com.vd.event.consumer.infrastructure.kafka.KafkaConsumer
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.test.context.ActiveProfiles

import java.nio.charset.StandardCharsets

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = [ "listeners=PLAINTEXT://localhost:9092", "port=9092" ])
@ActiveProfiles("test")
class ConsumerTestBaeldung {

    @Autowired
    public KafkaTemplate<String, String> template;

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker

//    @Value("${test.topic}")
    private String topic = "embedded-test-topic";

    @Test
    void givenEmbeddedKafkaBroker_whenSendingtoDefaultTemplate_thenMessageReceived() throws Exception {
        template.send(topic, "Sending with default template");

//
//        new ProducerRecord<String, String>(
//                COMSUMER_TOPIC,
//                0,
//                "123",
//                readFileAsString("deserialize/valid_event.json"))
    }

    private String readFileAsString(final String filePath) throws URISyntaxException {
        ClassLoader classLoader = this.getClass().getClassLoader()
        new String(new File(classLoader.getResource(filePath).toURI()).getBytes(), StandardCharsets.UTF_8)
    }

//    @Test
//    public void givenEmbeddedKafkaBroker_whenSendingtoSimpleProducer_thenMessageReceived() throws Exception {
//        producer.send(topic, "Sending with our own simple KafkaProducer");
//        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
//
//        assertThat(consumer.getLatch().getCount(), equalTo(0L));
//        assertThat(consumer.getPayload(), containsString("embedded-test-topic"));
//    }

//    @BeforeAll
//    void getKafkaTemplate(){
//        template = new KafkaTemplate<String, String>(new DefaultKafkaProducerFactory<>(KafkaTestUtils.producerProps(embeddedKafkaBroker)))
//    }
}
