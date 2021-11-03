package com.vd.event.consumer.config;

import com.vd.event.consumer.infrastructure.kafka.ErrorHandlerListener;
import com.vd.event.consumer.infrastructure.util.EnvUtil;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    @Primary
    public ConcurrentKafkaListenerContainerFactory<Object, Object> customKafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer listenerConfigurer,
            ConsumerFactory<Object, Object> kafkaConsumerFactory,
            ErrorHandlerListener errorHandlerListener
    ) {

        return null;
    }


}
