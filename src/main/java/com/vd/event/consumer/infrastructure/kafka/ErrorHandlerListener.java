//package com.vd.event.consumer.infrastructure.kafka;
//
//
//import com.vd.event.consumer.config.KafkaProperties;
//import com.vd.event.consumer.exception.RecoverableException;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.common.TopicPartition;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.listener.ErrorHandler;
//import org.springframework.kafka.listener.ListenerExecutionFailedException;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
////@Component
//@Lazy
//public class ErrorHandlerListener implements ErrorHandler {
//
////    private final KafkaProperties kafkaProperties;
//    private final KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//    private final ScheduledExecutorService scheduledExecutorService;
//
//    public ErrorHandlerListener(
////            KafkaProperties kafkaProperties,
//            KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry
//    ) {
////        this.kafkaProperties = kafkaProperties;
//        this.kafkaListenerEndpointRegistry = kafkaListenerEndpointRegistry;
//        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
//    }
//
//    @Override
//    public void handle(Exception thrownException, ConsumerRecord<?, ?> consumerRecord, Consumer<?, ?> consumer) {
//        if (thrownException instanceof ListenerExecutionFailedException
//                && ((ListenerExecutionFailedException) thrownException).getRootCause() instanceof RecoverableException) {
//
//            log.error("Failed to deliver message: {}. Reason: exception {} with message {}. About to retry after {} s.",
//                    consumerRecord.value(),
//                    thrownException.getClass().getName(),
//                    thrownException.getMessage(),
////                    kafkaProperties.getRestartPeriod());
//
//            this.kafkaListenerEndpointRegistry.stop();
//            this.scheduledExecutorService.schedule(
//                    this.kafkaListenerEndpointRegistry::start,
//                    this.kafkaProperties.getRestartPeriod(),
//                    TimeUnit.MILLISECONDS);
//        } else {
//            TopicPartition partition = new TopicPartition(
//                    consumerRecord.topic(),
//                    consumerRecord.partition()
//            );
//            consumer.seek(partition, consumerRecord.offset() + 1);
//            log.error("Discarding event for partition {}, offset now is {}.",
//                    consumerRecord.partition(), consumerRecord.offset() + 1
//            );
//
//            log.error("Failed to deliver message: {}. Reason exception: {}, with message: {}.",
//                    consumerRecord.value(), thrownException.getClass().getName(), thrownException.getMessage()
//            );
//        }
//    }
//
//
//    @Override
//    public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
//        // should be overridden because class implements ErrorHandler
//    }
//}
