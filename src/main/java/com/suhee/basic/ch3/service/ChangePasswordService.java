package com.suhee.basic.ch3.service;

import com.suhee.basic.ch3.dao.MemberDao;

public class ChangePasswordService {

	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
