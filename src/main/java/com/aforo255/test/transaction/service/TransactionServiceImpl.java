package com.aforo255.test.transaction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.test.transaction.dao.ITransactionDao;
import com.aforo255.test.transaction.domain.Transaction;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	private Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	private ITransactionDao transactionDao;

	@Override
	public Transaction save(Transaction transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId) {		
		Iterable<Transaction> result = transactionDao.findByInvoiceId(invoiceId);
		logger.info("findByInvoiceId result: [");
		result.forEach(e -> logger.info("e: " + e));
		logger.info("]");
		return result;
	}

	@Override
	public Iterable<Transaction> findAll() {
		return transactionDao.findAll();
	}

}
