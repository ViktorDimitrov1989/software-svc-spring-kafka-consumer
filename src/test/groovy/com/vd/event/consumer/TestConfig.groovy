//package com.vd.event.consumer
//
//import org.springframework.beans.factory.annotation.Autowire
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.TestConfiguration
//import org.springframework.context.annotation.Bean
//import org.springframework.kafka.core.DefaultKafkaProducerFactory
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.kafka.core.ProducerFactory
//import org.springframework.kafka.test.EmbeddedKafkaBroker
//import org.springframework.kafka.test.context.EmbeddedKafka
//import org.springframework.kafka.test.utils.KafkaTestUtils
//
//@TestConfiguration
//class TestConfig {
//
//    @Autowired
//    EmbeddedKafkaBroker embeddedKafkaBroker;
//
//    @Bean
//    ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(KafkaTestUtils.producerProps(embeddedKafkaBroker));
//    }
//
//    @Bean
//    KafkaTemplate<String, String> kafkaTemplate() {
//        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory());
//        kafkaTemplate.setDefaultTopic('default_topic')
//        return kafkaTemplate;
//    }
//}
