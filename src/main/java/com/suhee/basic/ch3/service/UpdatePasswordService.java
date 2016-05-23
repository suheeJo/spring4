package com.suhee.basic.ch3.service;

import com.suhee.basic.ch3.dao.MemberDao;
import com.suhee.basic.ch3.exception.IdPasswordNotMatchingException;
import com.suhee.basic.ch3.model.Member;

public class UpdatePasswordService {

	private MemberDao memberDao;
	
	public UpdatePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void updatePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new IdPasswordNotMatchingException();
		}
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
}
