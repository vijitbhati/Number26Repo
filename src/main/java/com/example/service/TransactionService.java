package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.helper.Status;
import com.example.helper.Sum;
import com.example.model.Transaction;

/**
 * Transaction service used for data manipulation functionality. 
 * 
 * @author j.snajderov
 *
 */
@Service
public interface TransactionService {
	public Sum getTransactionSumByParentId(int id);

	public List<Integer> getTransactionsByType(String type);

	public Status addTransaction(int id, Transaction transaction);
}
