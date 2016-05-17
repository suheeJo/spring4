package com.suhee.basic.ch3;

import java.util.Date;

import com.suhee.basic.ch3.exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	
	private MemberDao memberDao = new MemberDao();
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("dup email: " + req.getEmail());
		}
		
		Member newMember = new Member(null, req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}
