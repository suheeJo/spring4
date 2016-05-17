package com.suhee.basic.ch3.exception;

@SuppressWarnings("serial")
public class AlreadyExistingMemberException extends RuntimeException {
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
