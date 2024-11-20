package com.pingwit.part_49.property;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record JokeServerProperty(
        @Size(min = 3)
        String name,
//        @NotEmpty
        @NotBlank
        String url) {
}
