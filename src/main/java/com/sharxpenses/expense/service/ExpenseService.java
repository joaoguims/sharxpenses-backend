package com.sharxpenses.expense.service;

import com.sharxpenses.expense.entity.Expense;
import com.sharxpenses.expense.entity.ExpenseShare;
import com.sharxpenses.expense.repository.ExpenseRepository;
import com.sharxpenses.expense.repository.ExpenseShareRepository;
import com.sharxpenses.group.entity.Group;
import com.sharxpenses.group.entity.GroupMember;
import com.sharxpenses.group.repository.GroupRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepo;
    private final ExpenseShareRepository shareRepo;
    private final GroupRepository groupRepo;

    public ExpenseService(ExpenseRepository expenseRepo, ExpenseShareRepository shareRepo, GroupRepository groupRepo) {
        this.expenseRepo = expenseRepo;
        this.shareRepo = shareRepo;
        this.groupRepo = groupRepo;
    }

    public Expense createExpense(Long groupId, String description, Double amount, String category, String mode) {
        Group g = groupRepo.findById(groupId).orElseThrow();
        Expense e = new Expense();
        e.setDescription(description);
        e.setAmount(amount);
        e.setCategory(category);

        expenseRepo.save(e);

        List<GroupMember> members = g.getMembers().stream().toList();
        double shareValue = amount / members.size();

        for (GroupMember m : members) {
            ExpenseShare s = new ExpenseShare();
            s.setExpense(e);
            s.setUser(m.getUser());
            s.setAmountDue(shareValue);
            shareRepo.save(s);
            e.getShares().add(s);
        }
        return e;
    }

    public List<Expense> listExpenses() {
        return expenseRepo.findAll();
    }
}
