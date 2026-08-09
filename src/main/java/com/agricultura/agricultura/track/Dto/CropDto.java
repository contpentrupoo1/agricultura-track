package com.agricultura.agricultura.track.Dto;

import com.agricultura.agricultura.track.Entity.CropStatus;
import com.agricultura.agricultura.track.Entity.Plot;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record CropDto(Long id,
                      @NotNull(message = "A crop has to belong to a plot") Long plotida,
                      @NotNull(message = "A name is required") String name,
                      LocalDate start,
                      @NotNull(message = "A status is required") CropStatus status,
                      @PositiveOrZero(message = "The total yield cannot be negative") Double totalyield,
                      String variety) {
}
