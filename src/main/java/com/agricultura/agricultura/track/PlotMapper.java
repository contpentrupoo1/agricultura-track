package com.agricultura.agricultura.track;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlotMapper {
    PlotDto toDto(Plot entity);
    Plot toEntity(PlotDto dto);
}
