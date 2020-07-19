package com.aforo255.test.transaction.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.test.transaction.domain.Operation;
import com.aforo255.test.transaction.domain.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OperationEvents {
	
	private Logger logger = LoggerFactory.getLogger(OperationEvents.class);

	@Autowired
	private ITransactionService transactionService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processOperationEvents(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		Operation operationEvent = objectMapper.readValue(consumerRecord.value(), Operation.class);
		logger.info("OperationEvent proccessing: {}", consumerRecord.value());
		
		Transaction transaction = new Transaction();
		transaction.setId(operationEvent.getId().toString());
		transaction.setInvoice(operationEvent.getInvoice());
		transaction.setAmount(operationEvent.getAmount());
		transaction.setDate(operationEvent.getDatetime());
		transactionService.save(transaction);
	}
	
}
