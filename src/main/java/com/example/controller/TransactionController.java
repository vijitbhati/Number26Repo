package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.helper.Status;
import com.example.helper.Sum;
import com.example.model.Transaction;
import com.example.service.TransactionService;

/**
 * Transaction controller used for exposing available REST service end points
 * and calling the appropriate service methods in {@link TransactionService}.
 * 
 * @author j.snajderov
 *
 */
@RestController
@RequestMapping("/transactionservice")
public class TransactionController {
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransactionService transService;

	@RequestMapping(path = "/transaction/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Status> addTransaction(@PathVariable("id") int id, @RequestBody Transaction transaction) {
		logger.info("Entered addTransaction REST endpoint");
		Status addTransStatus = transService.addTransaction(id, transaction);
		return new ResponseEntity<Status>(addTransStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/types/{type}", method = RequestMethod.GET)
	public List<Integer> getTransactionsByType(@PathVariable("type") String type) {
		logger.info("Entered getTransactionsByType REST endpoint");
		List<Integer> transList = transService.getTransactionsByType(type);
		return transList;
	}

	@RequestMapping(value = "/sum/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sum> getTransactionSumByParentId(@PathVariable("id") int id) {
		logger.info("Entered getTransactionSumByParentId REST endpoint");
		Sum transSum = transService.getTransactionSumByParentId(id);
		return new ResponseEntity<Sum>(transSum, HttpStatus.OK);
	}

}