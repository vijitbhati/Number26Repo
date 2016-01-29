package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.example.helper.Status;
import com.example.helper.Sum;
import com.example.model.Transaction;

/**
 * Simple JUnit test class for testing {@link TransactionServiceImpl} service.
 * Purpose here is to check if business logic is working as expected. In more
 * complex application architectures this test could be extended using mocking
 * frameworks e.g. EasyMock or Mockito.
 * 
 * @author j.snajderov
 *
 */
public class TransactionServiceImplTest {
	TransactionServiceImpl transService = new TransactionServiceImpl();

	Map<Integer, Transaction> testTransMap = new HashMap<Integer, Transaction>();

	@Test
	public void testAddingTransaction() {
		transService.setTransMap(testTransMap);
		int id = 1;
		Transaction trans = new Transaction(100, "clothes");

		Status status = transService.addTransaction(id, trans);

		assertEquals("OK", status.getStatus());
		assertTrue(testTransMap.containsKey(id));
		assertEquals(trans, testTransMap.get(id));
	}

	@Test
	public void testGetByType() {
		int key1 = 10;
		int key2 = 11;
		Transaction trans1 = new Transaction(5000, "cars");
		Transaction trans2 = new Transaction(10000, "shopping", key1);
		testTransMap.put(key1, trans1);
		testTransMap.put(key2, trans2);
		transService.setTransMap(testTransMap);

		String type = "cars";

		List<Integer> trans = transService.getTransactionsByType(type);

		assertTrue(trans.size() == 1);
		assertTrue(trans.contains(key1));
	}

	@Test
	public void testGetSumByParentId() {
		int key1 = 10;
		int key2 = 11;
		Transaction trans1 = new Transaction(5000, "cars");
		Transaction trans2 = new Transaction(10000, "shopping", key1);
		testTransMap.put(key1, trans1);
		testTransMap.put(key2, trans2);
		transService.setTransMap(testTransMap);

		int parentId = key1;

		Sum sum = transService.getTransactionSumByParentId(parentId);

		assertTrue(trans1.getAmount() + trans2.getAmount() == sum.getSum());
	}
}
