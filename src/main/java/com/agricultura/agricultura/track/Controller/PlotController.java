package com.agricultura.agricultura.track.Controller;

import com.agricultura.agricultura.track.Dto.PlotDto;
import com.agricultura.agricultura.track.Dto.PlotSummaryDto;
import com.agricultura.agricultura.track.Service.PlotService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<PlotDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(plotService.getPlotById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlotDto>  updatePlot(@PathVariable Long id, @RequestBody PlotDto dto) {
        return ResponseEntity.ok().body(plotService.updatePlot(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlot(@PathVariable Long id) {
        plotService.deletePlot(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/summary")
    public ResponseEntity<PlotSummaryDto> dashboardStatusSummary() {
        return ResponseEntity.ok().body(plotService.dashboardStatusSummary());
    }

//    @PostMapping("/plots/{id}/crops")
//    public ResponseEntity<PlotDto> test () {
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }




}