package com.suhee.basic.ch3.main;

import com.suhee.basic.ch3.dao.CachedMemberDao;
import com.suhee.basic.ch3.dao.MemberDao;
import com.suhee.basic.ch3.service.UpdatePasswordService;
import com.suhee.basic.ch3.service.MemberRegisterService;

public class ConstructMain {

	public static void main(String[] args) {
		MemberDao memberDao = new CachedMemberDao();
		MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);
		UpdatePasswordService changePasswordService = new UpdatePasswordService(memberDao);
	}

}
