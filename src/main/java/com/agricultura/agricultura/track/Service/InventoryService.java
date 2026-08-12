package com.agricultura.agricultura.track.Service;

import com.agricultura.agricultura.track.Dto.InventoryDto;
import com.agricultura.agricultura.track.Entity.Inventory;
import com.agricultura.agricultura.track.Mapper.InventoryMapper;
import com.agricultura.agricultura.track.Repository.InventoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public InventoryService(InventoryRepository inventoryRepository, InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryMapper = inventoryMapper;
    }

    public void createInventory(InventoryDto dto) {
        Inventory inventory = inventoryMapper.toEntity(dto);

        inventoryRepository.save(inventory);
    }

    public Page<InventoryDto> getAllInventory(int page, int size, String sortCategory) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortCategory));

        Page<Inventory> inventoryPage = inventoryRepository.findAll(pageRequest);

        return inventoryPage.map(inventory -> inventoryMapper.toDto(inventory));
    }
}