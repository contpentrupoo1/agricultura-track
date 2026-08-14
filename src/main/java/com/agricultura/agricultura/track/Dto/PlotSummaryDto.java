package com.agricultura.agricultura.track.Dto;

import jakarta.validation.constraints.PositiveOrZero;

public record PlotSummaryDto(Long active,
                              Long fallow,
                              Long preparation,
                              Long readyForHarvest,
                              Long total) {
}
