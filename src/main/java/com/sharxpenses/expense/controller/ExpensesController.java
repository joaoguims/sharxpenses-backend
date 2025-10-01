package com.sharxpenses.expense.controller;

import com.sharxpenses.expense.entity.Expense;
import com.sharxpenses.expense.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups/{groupId}/expenses")
public class ExpensesController {
    private final ExpenseService service;

    public ExpensesController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public Expense create(@PathVariable Long groupId, @RequestParam String description,
                          @RequestParam Double amount, @RequestParam(required = false) String category,
                          @RequestParam(defaultValue = "EQUAL") String mode) {
        return service.createExpense(groupId, description, amount, category, mode);
    }

    @GetMapping
    public List<Expense> list() {
        return service.listExpenses();
    }
}
