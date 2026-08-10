package com.agricultura.agricultura.track.Controller;

import com.agricultura.agricultura.track.Dto.ExpenseLogDto;
import com.agricultura.agricultura.track.Service.ExpenseLogService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseLogController {

    private final ExpenseLogService expenseLogService;

    public ExpenseLogController(ExpenseLogService expenseLogService) {
        this.expenseLogService = expenseLogService;
    }

    @GetMapping
    public ResponseEntity<Page<ExpenseLogDto>> getExpenses(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortcategory", defaultValue = "id") String sortCategory) {

        return ResponseEntity.ok(expenseLogService.getAllExpenseLogs(page, size, sortCategory));
    }

    @PostMapping
    public ResponseEntity<Void> addExpense(@Valid @RequestBody ExpenseLogDto dto) {
        expenseLogService.createExpenseLog(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}