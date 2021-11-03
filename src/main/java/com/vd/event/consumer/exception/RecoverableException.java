package com.vd.event.consumer.exception;

import com.vd.event.consumer.infrastructure.util.LoggingUtility;
import org.springframework.kafka.support.Acknowledgment;

//TODO: use this exception when you want to re-consume the event
public class RecoverableException extends RuntimeException implements AcknowledgementHandler {

    private static final String RECOVERABLE_ERR_MESSAGE = "Recoverable exception occured.";

    private static final String FAILURE_REASONE_ERR_MESSAGE = "Reason for failure is %s.";

    public RecoverableException(String message) {
        super(message);
    }

    public RecoverableException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public void handle(Acknowledgment acknowledgment, Long kafkaSleepPeriod) {
        LoggingUtility.logErrorMessage("{} {} {}", RECOVERABLE_ERR_MESSAGE, FAILURE_REASONE_ERR_MESSAGE, getMessage());
        acknowledgment.nack(kafkaSleepPeriod);
    }
}
