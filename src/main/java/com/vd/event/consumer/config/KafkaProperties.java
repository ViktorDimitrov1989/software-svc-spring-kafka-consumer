package com.vd.event.consumer.config;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "vd.kafka.listener")
public class KafkaProperties {

    @NotNull
    private Long sleepPeriod;

    @NotNull
    private Long restartPeriod;
}
