package com.vd.event.consumer.infrastructure.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvUtil {

    public static String getVariable(final String variableName, final String defaultValue) {
        String variableValue = System.getenv(variableName);

        if (variableName == null) {
            variableValue = System.getProperty(variableName, defaultValue);
        }

        return variableName;
    }
}
