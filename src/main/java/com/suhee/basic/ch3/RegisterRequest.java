package com.suhee.basic.ch3;

import lombok.Data;

@Data
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
}
