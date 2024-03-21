package com.example.springresilienc4j.config;

import com.example.springresilienc4j.application.exception.IgnoreException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
class CircuitConfig {

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    @Bean
    public CircuitBreaker myCircuit() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(3)
            .waitDurationInOpenState(Duration.ofMillis(5000))
            .permittedNumberOfCallsInHalfOpenState(2)
            .slidingWindowSize(6)
            .automaticTransitionFromOpenToHalfOpenEnabled(true)
            .ignoreExceptions(IgnoreException.class)
            .build();

        return circuitBreakerRegistry.circuitBreaker("myCircuit", circuitBreakerConfig);
    }
}
