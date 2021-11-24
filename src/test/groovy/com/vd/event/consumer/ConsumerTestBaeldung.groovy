package com.vd.event.consumer

import com.vd.event.consumer.infrastructure.kafka.KafkaEventListener
import org.apache.kafka.clients.producer.ProducerRecord
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.test.context.ActiveProfiles

import java.nio.charset.StandardCharsets

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka
@ActiveProfiles("test")
class ConsumerTestBaeldung {

    public KafkaTemplate<String, String> template;

    @Autowired
    private KafkaEventListener consumer;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker

//    @Value("${vd.kafka.saas.topic}")
    private String topic = "default_topic";

    @Test
    public void givenEmbeddedKafkaBroker_whenSendingtoDefaultTemplate_thenMessageReceived() throws Exception {
        template.send(topic, readFileAsString("deserialize/valid_event.json"));

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

    @BeforeAll
    void getKafkaTemplate(){
        template = new KafkaTemplate<String, String>(new DefaultKafkaProducerFactory<>(KafkaTestUtils.producerProps(embeddedKafkaBroker)))
    }
}
