package com.agricultura.agricultura.track.Controller;

import com.agricultura.agricultura.track.Dto.WorkerDto;
import com.agricultura.agricultura.track.Service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<Page<WorkerDto>> getWorkers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortcategory", defaultValue = "id") String sortCategory) {

        return ResponseEntity.ok(workerService.getAllWorkers(page, size, sortCategory));
    }

    @PostMapping
    public ResponseEntity<Void> addWorker(@Valid @RequestBody WorkerDto dto) {
        workerService.createWorker(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDto> getWorkerById (Long id) {
        return ResponseEntity.ok(workerService.getWorkerById(id));
    }

}