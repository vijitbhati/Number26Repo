package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.helper.Status;
import com.example.helper.Sum;
import com.example.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	private Map<Integer, Transaction> transMap = new HashMap<Integer, Transaction>();

	@Override
	public Sum getTransactionSumByParentId(int id) {
		logger.info("Getting transaction sum by parent id");
		Sum sum = new Sum(0);
		sum.add(transMap.get(id).getAmount());
		for (Map.Entry<Integer, Transaction> entry : transMap.entrySet()) {
			logger.info("Map entry with key ({}) is: {}", entry.getKey(), entry.getValue());
			if (entry.getValue().getParent_id() == id)
				sum.add(entry.getValue().getAmount());
		}
		return sum;
	}

	@Override
	public List<Integer> getTransactionsByType(String type) {
		logger.info("Getting transactions by type");
		List<Integer> transList = new ArrayList<Integer>();
		for (Map.Entry<Integer, Transaction> entry : transMap.entrySet()) {
			logger.info("Map entry with key ({}) is: {}", entry.getKey(), entry.getValue());
			if (entry.getValue().getType().equals(type))
				transList.add(entry.getKey());
		}
		return transList;
	}

	@Override
	public Status addTransaction(int id, Transaction transaction) {
		logger.info("Adding transaction: {}", transaction);
		transMap.put(id, transaction);
		return new Status("OK");
	}

	public void setTransMap(Map<Integer, Transaction> transMap) {
		this.transMap = transMap;
	}

}
