package com.agricultura.agricultura.track.Dto;

import com.agricultura.agricultura.track.Entity.PlotStatus;
import com.agricultura.agricultura.track.Entity.PlotType;
import org.antlr.v4.runtime.misc.NotNull;

public record PlotDto(Long id,
                      @NotNull String name,
                      Double size,
                      @NotNull PlotType type,
                      @NotNull PlotStatus status) {

}
