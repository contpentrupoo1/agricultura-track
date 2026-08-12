package com.agricultura.agricultura.track.Controller;

import com.agricultura.agricultura.track.Dto.InventoryDto;
import com.agricultura.agricultura.track.Service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<Page<InventoryDto>> getInventory(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortcategory", defaultValue = "id") String sortCategory) {

        return ResponseEntity.ok(inventoryService.getAllInventory(page, size, sortCategory));
    }

    @PostMapping
    public ResponseEntity<Void> addInventory(@Valid @RequestBody InventoryDto dto) {

        inventoryService.createInventory(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}