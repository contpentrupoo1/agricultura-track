package com.agricultura.agricultura.track.Mapper;

import com.agricultura.agricultura.track.Dto.CropDto;
import com.agricultura.agricultura.track.Entity.Crop;
import org.springframework.stereotype.Component;

@Component
public class CropMapper {

    public CropDto toDto(Crop entity) {
        if(entity == null) {
            return null;
        }

        Long plotida = null;
        if(entity.getPlot() != null) {
            plotida = entity.getPlot().getId();
        }

        return new CropDto(entity.getId(), plotida, entity.getName(), entity.getStart(),
                entity.getStatus(), entity.getTotalyield(), entity.getVariety());

    }

    public Crop toEntity(CropDto dto) {
        if(dto == null) {
            return null;
        }

        Crop crop = new Crop();
        crop.setId(dto.id());
        crop.setName(dto.name());
        crop.setStart(dto.start());
        crop.setStatus(dto.status());
        crop.setTotalyield(dto.totalyield());
        crop.setVariety(dto.variety());


        return crop;
    }
}

