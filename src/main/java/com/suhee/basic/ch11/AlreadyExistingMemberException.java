package com.suhee.basic.ch11;

@SuppressWarnings("serial")
public class AlreadyExistingMemberException extends RuntimeException {
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
