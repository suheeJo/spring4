package com.suhee.basic.ch5;

@SuppressWarnings("serial")
public class AlreadyExistingMemberException extends RuntimeException {
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
