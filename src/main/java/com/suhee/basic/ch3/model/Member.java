package com.suhee.basic.ch3.model;

import java.util.Date;

import com.suhee.basic.ch3.exception.IdPasswordNotMatchingException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!this.password.equals(oldPassword)) throw new IdPasswordNotMatchingException();

		this.password = newPassword;
	}
}
