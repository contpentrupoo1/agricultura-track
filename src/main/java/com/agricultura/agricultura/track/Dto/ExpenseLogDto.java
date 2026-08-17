package com.agricultura.agricultura.track.Dto;

import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

public record ExpenseLogDto(
        Long id,

        Long cropId,

        Long inventoryId,

        Long workerId,

        String productionphase,

        @PositiveOrZero(message = "Quantity used cannot be negative")
        Double quantityused,

        @PositiveOrZero(message = "Total cost cannot be negative")
        Double totalcost,

        LocalDateTime timestamp
) {}