package com.sharxpenses.expense.repository;

import com.sharxpenses.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findBySharesUserId(Long userId);
}
