package com.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.dto.TransactionDto;
import com.bank.model.Transaction;
import com.bank.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	
	private final TransactionService transactionservice;

	public TransactionController(TransactionService transactionservice) {
		this.transactionservice = transactionservice;
	}

	@PostMapping
	public ResponseEntity<Transaction> recordTransaction(@RequestBody TransactionDto trans) {
		Transaction recordTransaction = transactionservice.recordTransaction(trans);
		return new ResponseEntity<>(recordTransaction, HttpStatus.ACCEPTED);
	}
}
