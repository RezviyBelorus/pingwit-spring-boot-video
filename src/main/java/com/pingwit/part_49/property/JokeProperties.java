package com.pingwit.part_49.property;

import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@ConfigurationProperties(prefix = "api.jokes")
@Validated
public record JokeProperties(
        String url,
        @Size(min = 3)
        List<JokeServerProperty> servers) {
}
