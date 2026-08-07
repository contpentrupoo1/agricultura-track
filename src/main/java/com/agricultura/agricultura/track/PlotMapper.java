package com.agricultura.agricultura.track;

import org.springframework.stereotype.Component;

@Component
public class PlotMapper {
    public PlotDto toDto(Plot entity) {
        if (entity == null) {
            return null;
        }
        return new PlotDto(
                entity.getId(),
                entity.getName(),
                entity.getSize(),
                entity.getType(),
                entity.getStatus()
        );
    }
    public Plot toEntity(PlotDto dto) {
        if (dto == null) {
            return null;
        }
        Plot plot = new Plot();
        plot.setId(dto.id());
        plot.setName(dto.name());
        plot.setSize(dto.size());
        plot.setType(dto.type());
        plot.setStatus(dto.status());
        return plot;
    }
}
