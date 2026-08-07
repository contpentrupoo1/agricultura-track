package com.agricultura.agricultura.track;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plots")
public class PlotController {

    private final PlotService plotService;

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping
    public ResponseEntity<Page<PlotDto>> getPlots(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortcategory", defaultValue = "id") String sortcategory) {

        return ResponseEntity.ok().body(plotService.getAllPlots(page, size, sortcategory));
    }

    @PostMapping
    public ResponseEntity<Void> addPlot(@RequestBody PlotDto dto) {
        plotService.createPlot(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}