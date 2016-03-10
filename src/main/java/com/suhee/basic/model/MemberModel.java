package com.suhee.basic.model;

import java.util.Date;

import lombok.Data;

@Data
public class MemberModel {
	private long no;
	private String id;
	private String password;
	private String name;
	private String gender;
	private Date birthday;
	private Date registerDate;
	private Date updateDate;
}
