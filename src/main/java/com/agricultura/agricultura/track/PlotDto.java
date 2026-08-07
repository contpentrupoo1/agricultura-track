package com.agricultura.agricultura.track;

import org.antlr.v4.runtime.misc.NotNull;

public record PlotDto(Long id,
                      @NotNull String name,
                      Double size,
                      @NotNull PlotType type,
                      @NotNull PlotStatus status) {

}
