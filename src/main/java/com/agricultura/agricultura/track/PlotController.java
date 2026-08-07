package com.agricultura.agricultura.track;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plots")
@RequiredArgsConstructor
public class PlotController {

    private final PlotService plotService;

    @GetMapping
    public ResponseEntity<Page<PlotDto>> getPlots(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size,
            @RequestParam(name = "sortcategory") String sortcategory) {

        return ResponseEntity.ok().body(plotService.getAllPlots(page, size, sortcategory));
    }

    @PostMapping
    public ResponseEntity<Void> addPlot(@RequestBody PlotDto dto) {
        plotService.createPlot(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}