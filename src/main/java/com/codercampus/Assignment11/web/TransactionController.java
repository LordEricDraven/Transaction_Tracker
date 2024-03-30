package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String getTransactions(Model model) {
		List<Transaction> transactions = transactionService.findAll();
		model.addAttribute("transactions", transactions);
		return "/transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransaction(@PathVariable Long transactionId, Model model) {
		Transaction transaction = transactionService.findById(transactionId);
		model.addAttribute("transaction", transaction);
		return "/transaction";
	}
}
