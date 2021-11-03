package com.vd.event.consumer.exception;

import org.springframework.kafka.support.Acknowledgment;

public interface AcknowledgementHandler {

    void handle(Acknowledgment acknowledgment, Long kafkaSleepPeriod);
}
