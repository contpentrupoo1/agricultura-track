package com.agricultura.agricultura.track.Dto;

import com.agricultura.agricultura.track.Entity.PlotStatus;
import com.agricultura.agricultura.track.Entity.PlotType;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Min;


public record PlotDto(Long id,
                      @NotNull(message = "A name is required") String name,
                      @Min(value = 1, message = "The value must be greater than or equal to 1") Double size,
                      @NotNull(message = "A type is required") PlotType type,
                      @NotNull(message = "A status is required") PlotStatus status) {

}
