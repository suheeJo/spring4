package com.suhee.basic.ch3.model;

import java.util.Date;

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
}
