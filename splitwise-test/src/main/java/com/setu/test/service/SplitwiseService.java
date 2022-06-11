package com.setu.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.setu.test.dao.SplitwiseDao;
import com.setu.test.entity.Expense;
import com.setu.test.entity.User;
import com.setu.test.model.EqualExpenseModel;
import com.setu.test.model.ExactExpenseModel;
import com.setu.test.model.PercentageExpenseModel;
import com.setu.test.model.ResponseModel;
import com.setu.test.model.SettleExpenseModel;
import com.setu.test.model.UserDue;
import com.setu.test.model.UserDuesModel;
import com.setu.test.model.UserModel;
import com.setu.test.model.UserPercentage;
import com.setu.test.model.UserValuePairModel;

@Service
public class SplitwiseService {
	@Autowired
	private SplitwiseDao dao;

	public ResponseModel createUser(UserModel userModel) {
		ResponseModel resp = null;
		try {
			User user = new User(userModel.getName(), userModel.getPhone());
			dao.createUser(user);
			resp = new ResponseModel("OK", "200", "User Added Successfully", null);
		} catch (Exception e) {
			resp = new ResponseModel("KO", "500", "Error : " + e.getMessage(), null);
		}
		return resp;
	}

	public ResponseModel addExpenditure(String expenseType, String expenseJson) {
		ResponseModel resp = null;
		Gson gson = new Gson();
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			switch (expenseType) {
			case "EQUAL":
				EqualExpenseModel model = gson.fromJson(expenseJson, EqualExpenseModel.class);
				for (int paidForUser : model.getUsers()) {
					User paidBy = dao.getUserById(model.getPaidBy());
					User paidFor = dao.getUserById(paidForUser);
					Expense expense = new Expense(model.getAmount(), paidBy, paidFor,
							(model.getAmount() / (model.getUsers().size() + 1)), "N", 0);
					expenses.add(expense);
				}
				dao.addExpenditures(expenses);
				resp = new ResponseModel("OK", "200", "Expense Added Successfully", null);
				break;

			case "PERCENTAGE":
				PercentageExpenseModel perModel = gson.fromJson(expenseJson, PercentageExpenseModel.class);
				for (UserPercentage user : perModel.getUserPercentages()) {
					User paidByPer = dao.getUserById(perModel.getPaidBy());
					User paidForPer = dao.getUserById(user.getUserId());
					Expense expense = new Expense(perModel.getAmount(), paidByPer, paidForPer,
							((perModel.getAmount() * user.getPercentage()) / 100.0), "N", 0);
					expenses.add(expense);
				}
				dao.addExpenditures(expenses);
				resp = new ResponseModel("OK", "200", "Expense Added Successfully", null);
				break;

			case "EXACT":
				ExactExpenseModel model2 = gson.fromJson(expenseJson, ExactExpenseModel.class);
				for (UserDue user : model2.getUserDues()) {
					User paidByExact = dao.getUserById(model2.getPaidBy());
					User paidForExact = dao.getUserById(user.getUserId());
					Expense expense = new Expense(model2.getAmount(), paidByExact, paidForExact, user.getUserAmount(),
							"N", 0);
					expenses.add(expense);
				}
				dao.addExpenditures(expenses);
				resp = new ResponseModel("OK", "200", "Expense Added Successfully", null);
				break;
			}
		} catch (Exception e) {
			resp = new ResponseModel("KO", "500", "Error : " + e.getMessage(), null);
		}
		return resp;
	}

	public ResponseModel settleExpenditure(SettleExpenseModel expenseModel) {
		ResponseModel resp = null;
		try {
			Expense existingExpenseRecord = dao.getExpenseById(expenseModel.getId());
			if (existingExpenseRecord != null) {
				existingExpenseRecord.setClearedDues(expenseModel.getAmount());
				if (existingExpenseRecord.getDue() == expenseModel.getAmount()) {
					existingExpenseRecord.setIsSettled("Y");
					existingExpenseRecord.setDue(existingExpenseRecord.getDue() - expenseModel.getAmount());
				}
				else if (existingExpenseRecord.getDue() > expenseModel.getAmount())
					existingExpenseRecord.setDue(existingExpenseRecord.getDue() - expenseModel.getAmount());
				else
					resp = new ResponseModel("KO", "200", "Error : Amount paid cannot be more than due amount.", null);
				dao.settleExpenditure(existingExpenseRecord);
				resp = new ResponseModel("OK", "200", "Settlement saved.", null);
			} else
				resp = new ResponseModel("KO", "500", "Error : No existing expense record for entered id.", null);

		} catch (Exception e) {
			resp = new ResponseModel("KO", "500", "Error : " + e.getMessage(), null);
		}
		return resp;
	}

	public ResponseModel getDueDetails(int userId) {
		ResponseModel resp = null;
		List<UserDuesModel> userDues = new ArrayList<UserDuesModel>();
		try {
			User user = dao.getUserById(userId);
			if (user != null) {
				List<Expense> dueExpenses = dao.getDueExpenses(user);
				List<UserValuePairModel> dueUserList = new ArrayList<UserValuePairModel>();
				for (Expense expense : dueExpenses) {
					String name = expense.getPaidBy().getName();
					UserValuePairModel pairModel = new UserValuePairModel(name, expense.getDue());
					dueUserList.add(pairModel);
				}
				UserDuesModel duesModel = new UserDuesModel();
				duesModel.setType("Due");
				duesModel.setMessage("Money to be paid.");
				duesModel.setUserValueList(dueUserList);
				userDues.add(duesModel);

				List<Expense> owedExpenses = dao.getOwedExpenses(user);
				List<UserValuePairModel> owedUserList = new ArrayList<UserValuePairModel>();
				for (Expense expense : owedExpenses) {
					String name = expense.getPaidFor().getName();
					UserValuePairModel pairModel = new UserValuePairModel(name, expense.getDue());
					owedUserList.add(pairModel);
				}
				UserDuesModel duesModel2 = new UserDuesModel();
				duesModel2.setType("Owed");
				duesModel2.setMessage("Money to be received.");
				duesModel2.setUserValueList(owedUserList);
				userDues.add(duesModel2);

				resp = new ResponseModel("OK", "200", "Returing Due List", userDues);
			}
		} catch (Exception e) {
			resp = new ResponseModel("KO", "500", "Error : " + e.getMessage(), null);
		}
		return resp;
	}
}
