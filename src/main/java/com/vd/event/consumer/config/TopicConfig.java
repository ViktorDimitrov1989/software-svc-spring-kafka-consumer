//package com.vd.event.consumer.config;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
// NOT NEEDED
//@Configuration
//public class TopicConfig {
//
//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
//
//    @Value(value = "${vd.kafka.saas.topic}")
//    private String topicName;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic(topicName, 1, (short) 1);
//    }
//}
