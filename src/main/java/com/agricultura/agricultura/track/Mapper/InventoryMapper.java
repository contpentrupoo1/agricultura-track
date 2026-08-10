package com.agricultura.agricultura.track.Mapper;

import com.agricultura.agricultura.track.Dto.InventoryDto;
import com.agricultura.agricultura.track.Entity.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {

    public InventoryDto toDto(Inventory entity) {
        if (entity == null) {
            return null;
        }

        return new InventoryDto(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getUnitcost(),
                entity.getUnittype()
        );
    }

    public Inventory toEntity(InventoryDto dto) {
        if (dto == null) {
            return null;
        }

        Inventory inventory = new Inventory();
        inventory.setId(dto.id());
        inventory.setName(dto.name());
        inventory.setCategory(dto.category());
        inventory.setUnitcost(dto.unitcost());
        inventory.setUnittype(dto.unittype());

        return inventory;
    }
}