package com.setu.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.setu.test.model.ResponseModel;
import com.setu.test.model.SettleExpenseModel;
import com.setu.test.model.UserModel;
import com.setu.test.service.SplitwiseService;

@RestController
public class SplitController {
	@Autowired
	private SplitwiseService service;

	@CrossOrigin
	@PostMapping("/createUser")
	public @ResponseBody ResponseModel createUser(@RequestBody String user) {
		ResponseModel resp = null;
		if (!user.isEmpty()) {
			Gson gson = new Gson();
			UserModel userModel = gson.fromJson(user, UserModel.class);
			resp = service.createUser(userModel);
		} else
			resp = new ResponseModel("KO", "200", "Validation Error : Entered JSON body is empty.", null);
		return resp;
	}

	@CrossOrigin
	@PostMapping("/addExpense")
	public @ResponseBody ResponseModel addExpenditure(@RequestParam(required = true) String expenseType,
			@RequestBody String expense) {
		ResponseModel resp = null;
		if (!expense.isEmpty() && !expenseType.isEmpty()) {
			resp = service.addExpenditure(expenseType, expense);
		} else
			resp = new ResponseModel("KO", "200", "Validation Error : Entered expense JSON body is empty.", null);

		return resp;
	}

	@CrossOrigin
	@PostMapping("/settleExpense")
	public @ResponseBody ResponseModel settleExpenditure(@RequestBody String settleExpense) {
		ResponseModel resp = null;
		if (!settleExpense.isEmpty()) {
			Gson gson = new Gson();
			SettleExpenseModel settleExpenseModel = gson.fromJson(settleExpense, SettleExpenseModel.class);
			resp = service.settleExpenditure(settleExpenseModel);
		} else
			resp = new ResponseModel("KO", "200", "Validation Error : Entered settle expense JSON body is empty.",
					null);

		return resp;
	}

	@CrossOrigin
	@GetMapping("/getDueDetails")
	public @ResponseBody ResponseModel getDueDetails(@RequestParam int userId) {
		ResponseModel resp = null;
		if (userId > 0) {
			Gson gson = new Gson();
			resp = service.getDueDetails(userId);
		} else
			resp = new ResponseModel("KO", "200", "Validation Error : Entered userId is invalid.", null);

		return resp;
	}

//	public @ResponseBody ResponseModel getTransactions(@RequestParam int userId) {
//
//	}
}
