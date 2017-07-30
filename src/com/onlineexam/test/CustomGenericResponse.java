package com.onlineexam.test;

import java.util.ArrayList;
import java.util.List;

public class CustomGenericResponse {

	/**
	 * true if successful.
	 */
	private Boolean success;

	/**
	 * Any custom message, i.e, 'Your request has been processed successfully!'
	 */
	private List<String> message;

	public CustomGenericResponse() {
		message = new ArrayList<String>();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message.add(message);
	}

}