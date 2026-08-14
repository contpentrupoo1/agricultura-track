package com.agricultura.agricultura.track.Controller;

import com.agricultura.agricultura.track.Dto.CropDto;
import com.agricultura.agricultura.track.Service.CropService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crops")
public class CropController {
    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping
    public ResponseEntity<Page<CropDto>> getCrops(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortcategory", defaultValue = "id") String sortCategory) {

        return ResponseEntity.ok().body(cropService.getAllCrops(page, size, sortCategory));
    }

    @PostMapping
    public ResponseEntity<Void> addCrop(@Valid @RequestBody CropDto dto) {
        cropService.createCrop(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}


