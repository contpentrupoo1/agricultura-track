package com.agricultura.agricultura.track.Mapper;

import com.agricultura.agricultura.track.Dto.ExpenseLogDto;
import com.agricultura.agricultura.track.Entity.ExpenseLog;
import org.springframework.stereotype.Component;

@Component
public class ExpenseLogMapper {

    // Map Entity to DTO
    public ExpenseLogDto toDto(ExpenseLog entity) {
        if (entity == null) {
            return null;
        }

        // Safely extract IDs to prevent null pointer exceptions
        Long cropId = (entity.getCrop() != null) ? entity.getCrop().getId() : null;
        Long inventoryId = (entity.getInventory() != null) ? entity.getInventory().getId() : null;

        return new ExpenseLogDto(
                entity.getId(),
                cropId,
                inventoryId,
                entity.getProductionphase(),
                entity.getQuantityused(),
                entity.getTotalcost(),
                entity.getTimestamp()
        );
    }

    // Map DTO to Entity
    public ExpenseLog toEntity(ExpenseLogDto dto) {
        if (dto == null) {
            return null;
        }

        ExpenseLog expenseLog = new ExpenseLog();
        expenseLog.setId(dto.id());
        expenseLog.setProductionphase(dto.productionphase());
        expenseLog.setQuantityused(dto.quantityused());
        expenseLog.setTotalcost(dto.totalcost());
        expenseLog.setTimestamp(dto.timestamp());

        // Note: Crop and Inventory are NOT set here. The Service will attach them!
        return expenseLog;
    }
}