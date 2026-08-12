package com.agricultura.agricultura.track.Controller;

import com.agricultura.agricultura.track.Dto.PlotDto;
import com.agricultura.agricultura.track.Service.PlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get all plots", description = "Returns a paginated list of agricultural plots")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of plots"),
            @ApiResponse(responseCode = "400", description = "Invalid pagination parameters provided"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Page<PlotDto>> getPlots(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortcategory", defaultValue = "id") String sortcategory) {

        return ResponseEntity.ok().body(plotService.getAllPlots(page, size, sortcategory));
    }

    @PostMapping
    @Operation(summary = "Create a new plot", description = "Adds a new agricultural plot to the database")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Plot successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid plot data provided in the request body"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> addPlot(@RequestBody PlotDto dto) {
        plotService.createPlot(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}