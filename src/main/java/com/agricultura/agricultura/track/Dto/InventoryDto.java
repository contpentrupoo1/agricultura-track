package com.agricultura.agricultura.track.Dto;

import com.agricultura.agricultura.track.Entity.Category;
import com.agricultura.agricultura.track.Entity.Unit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record InventoryDto(
        Long id,

        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Category is required")
        Category category,

        @PositiveOrZero(message = "Unit cost cannot be negative")
        Double unitcost,

        @NotNull(message = "Unit type is required")
        Unit unittype
) {}