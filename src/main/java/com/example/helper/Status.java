package com.example.helper;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.controller.TransactionController;

/**
 * Helper Status class used for formatting JSON response in {@link ResponseBody}
 * in {@link TransactionController} for addTransaction end point.
 * 
 * @author j.snajderov
 *
 */
public class Status {
	String status;

	public Status(String status) {
		this.status = status;
	}

	public Status() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
