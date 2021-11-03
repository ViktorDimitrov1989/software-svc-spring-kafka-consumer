package com.vd.event.consumer.infrastructure.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggingUtility {

    public static void logErrorMessage(String template, String... message) {
        log.error(template, message);
    }
}
