package com.aforo255.test.transaction.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.aforo255.test.transaction.domain.Transaction;

public interface ITransactionDao extends MongoRepository<Transaction, String>{

	@Query("{'id_invoice':?0}")
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId);
	
}
