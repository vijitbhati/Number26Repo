package com.example.helper;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.controller.TransactionController;

/**
 * Helper Sum class used for calculating simple double sum and for formatting
 * JSON response in {@link ResponseBody} in {@link TransactionController} for
 * getTransactionSumByParentId end point.
 * 
 * @author j.snajderov
 *
 */
public class Sum {
	double sum;

	public Sum(double sum) {
		super();
		this.sum = sum;
	}

	Sum() {
	}

	public double getSum() {
		return sum;
	}

	public void add(double value) {
		this.sum += value;
	}

}
