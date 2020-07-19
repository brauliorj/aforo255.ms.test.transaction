package com.aforo255.test.transaction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.test.transaction.domain.Transaction;
import com.aforo255.test.transaction.service.ITransactionService;

@RestController
public class TransactionController {
	
	private Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private ITransactionService transactionService;
	
	@GetMapping("/transactions")
	public List<Transaction> transactions() {
		return (List<Transaction>) transactionService.findAll();
	}
	
	@GetMapping("/transaction/{invoiceId}")
	public ResponseEntity<?> getTransaction(@PathVariable Integer invoiceId) {
		logger.info("Searching transactions by invoice: {}", invoiceId);
		Iterable<Transaction> iTransaction = transactionService.findByInvoiceId(invoiceId);
		return ResponseEntity.ok(iTransaction);
	}
	
}
