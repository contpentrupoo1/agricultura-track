package com.agricultura.agricultura.track.Service;

import com.agricultura.agricultura.track.Dto.ExpenseLogDto;
import com.agricultura.agricultura.track.Entity.Crop;
import com.agricultura.agricultura.track.Entity.ExpenseLog;
import com.agricultura.agricultura.track.Entity.Inventory;
import com.agricultura.agricultura.track.Mapper.ExpenseLogMapper;
import com.agricultura.agricultura.track.Repository.CropRepository;
import com.agricultura.agricultura.track.Repository.ExpenseLogRepository;
import com.agricultura.agricultura.track.Repository.InventoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ExpenseLogService {

    private final ExpenseLogRepository expenseLogRepository;
    private final CropRepository cropRepository;
    private final InventoryRepository inventoryRepository;
    private final ExpenseLogMapper expenseLogMapper;

    // Inject all required repositories
    public ExpenseLogService(ExpenseLogRepository expenseLogRepository,
                             CropRepository cropRepository,
                             InventoryRepository inventoryRepository,
                             ExpenseLogMapper expenseLogMapper) {
        this.expenseLogRepository = expenseLogRepository;
        this.cropRepository = cropRepository;
        this.inventoryRepository = inventoryRepository;
        this.expenseLogMapper = expenseLogMapper;
    }

    public void createExpenseLog(ExpenseLogDto dto) {
        // Map basic fields
        ExpenseLog expenseLog = expenseLogMapper.toEntity(dto);

        // Safely find and attach the Crop if a cropId was provided
        if (dto.cropId() != null) {
            Crop crop = cropRepository.findById(dto.cropId())
                    .orElseThrow(() -> new RuntimeException("Crop not found with id: " + dto.cropId()));
            expenseLog.setCrop(crop);
        }

        // Safely find and attach the Inventory item if an inventoryId was provided
        if (dto.inventoryId() != null) {
            Inventory inventory = inventoryRepository.findById(dto.inventoryId())
                    .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + dto.inventoryId()));
            expenseLog.setInventory(inventory);
        }

        // Save the fully assembled ExpenseLog
        expenseLogRepository.save(expenseLog);
    }

    public Page<ExpenseLogDto> getAllExpenseLogs(int page, int size, String sortCategory) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortCategory));
        Page<ExpenseLog> expensePage = expenseLogRepository.findAll(pageRequest);
        return expensePage.map(expenseLog -> expenseLogMapper.toDto(expenseLog));
    }
}