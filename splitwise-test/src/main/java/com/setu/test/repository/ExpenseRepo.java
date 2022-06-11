package com.setu.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.setu.test.entity.Expense;
import com.setu.test.entity.User;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {

	@Query("SELECT expense from Expense expense WHERE expense.paidFor =:id and expense.isSettled = 'N'")
	List<Expense> getDueExpenses(User id);
	
	@Query("SELECT expense from Expense expense WHERE expense.paidBy =:id and expense.isSettled = 'N'")
	List<Expense> getOwedExpenses(User id);
}
