package com.aforo255.test.transaction.service;

import com.aforo255.test.transaction.domain.Transaction;

public interface ITransactionService {
	
	public Transaction save(Transaction transaction);
	
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId);
	
	public Iterable<Transaction> findAll();

}
