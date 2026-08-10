package com.agricultura.agricultura.track.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record WorkerDto(
        Long id,

        @NotBlank(message = "Worker name is required")
        String name,

        @PositiveOrZero(message = "Rate cannot be negative")
        Double rate
) {}