package com.setu.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.setu.test.entity.Expense;
import com.setu.test.entity.User;
import com.setu.test.repository.ExpenseRepo;
import com.setu.test.repository.UserRepo;

@Repository
public class SplitwiseDao {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ExpenseRepo expenseRepo;

	public void createUser(User user) {
		userRepo.save(user);
	}

	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}

	public void addExpenditures(List<Expense> expense) {
		expenseRepo.saveAll(expense);
	}
	
	public void settleExpenditure(Expense expense) {
		expenseRepo.save(expense);
	}
	
	public Expense getExpenseById(int id) {
		return expenseRepo.findById(id).get();
	}
	
	public List<Expense> getDueExpenses(User id){
		return expenseRepo.getDueExpenses(id);
	}
	
	public List<Expense> getOwedExpenses(User id){
		return expenseRepo.getOwedExpenses(id);
	}
}
