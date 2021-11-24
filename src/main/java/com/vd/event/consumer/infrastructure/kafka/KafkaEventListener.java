package com.vd.event.consumer.infrastructure.kafka;

import com.vd.event.consumer.infrastructure.kafka.model.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventListener {

    @KafkaListener(
//            id = "KafkaConsumer",
            topics = "${vd.kafka.saas.topic}",
            //TODO: uncomment those
//            groupId = "${vd.kafka.saas.parameters.clientId}.${vd.kafka.saas.parameters.envId}.kc-group",
            containerFactory = "customKafkaListenerContainerFactory"
    )
    void receive(
            @Payload CustomEvent event
//            @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
//            @Header(KafkaHeaders.GROUP_ID) String groupId,
//            @Header(KafkaHeaders.TOPIC) String topc,
//            @Header(KafkaHeaders.PARTITION_ID) Integer partiotion,
//            @Header(KafkaHeaders.OFFSET) Long offset
            ) {
        log.info("Message consumed");
    }
}
