package com.suhee.basic.ch3.assembler;

import com.suhee.basic.ch3.service.ChangePasswordService;
import com.suhee.basic.ch3.service.MemberRegisterService;

import lombok.Getter;

import com.suhee.basic.ch3.dao.MemberDao;

@Getter
public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	public Assembler() {
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);
		changePasswordService = new ChangePasswordService(memberDao);
	}
}
