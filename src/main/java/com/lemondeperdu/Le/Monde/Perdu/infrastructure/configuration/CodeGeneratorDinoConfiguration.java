package com.lemondeperdu.Le.Monde.Perdu.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CodeGeneratorDinoConfiguration {

    public String generateCode(String code) {
        long currentTime = System.currentTimeMillis();
        long random = UUID.randomUUID().getLeastSignificantBits();
        long rawValue = Math.abs(currentTime ^ random);

        return Long.toString(rawValue, 36).toUpperCase(); // Exemple : "KD7X9Y2J"
    }
}
