package com.suhee.basic.ch3.service;

import java.util.Date;

import com.suhee.basic.ch3.dao.MemberDao;
import com.suhee.basic.ch3.exception.AlreadyExistingMemberException;
import com.suhee.basic.ch3.model.Member;
import com.suhee.basic.ch3.model.RegisterRequest;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("dup email: " + req.getEmail());
		}
		
		Member newMember = new Member(null, req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}
