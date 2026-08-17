package com.agricultura.agricultura.track.Mapper;

import com.agricultura.agricultura.track.Dto.ExpenseLogDto;
import com.agricultura.agricultura.track.Entity.ExpenseLog;
import org.springframework.stereotype.Component;

@Component
public class ExpenseLogMapper {

    public ExpenseLogDto toDto(ExpenseLog entity) {
        if (entity == null) {
            return null;
        }

        Long cropId = (entity.getCrop() != null) ? entity.getCrop().getId() : null;
        Long inventoryId = (entity.getInventory() != null) ? entity.getInventory().getId() : null;
        Long workerId = (entity.getWorker() != null) ? entity.getWorker().getId() : null;

        return new ExpenseLogDto(
                entity.getId(),
                cropId,
                inventoryId,
                workerId,
                entity.getProductionphase(),
                entity.getQuantityused(),
                entity.getTotalcost(),
                entity.getTimestamp()
        );
    }

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

        return expenseLog;
    }
}