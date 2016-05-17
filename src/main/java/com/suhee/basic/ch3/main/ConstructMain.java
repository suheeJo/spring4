package com.suhee.basic.ch3.main;

import com.suhee.basic.ch3.dao.MemberDao;
import com.suhee.basic.ch3.service.MemberRegisterService;

public class ConstructMain {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);
	}

}
