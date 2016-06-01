package com.suhee.basic.ch4.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.suhee.basic.ch4.dao.MemberDao;
import com.suhee.basic.ch4.exception.AlreadyExistingMemberException;
import com.suhee.basic.ch4.model.Member;
import com.suhee.basic.ch4.model.RegisterRequest;

public class MemberRegisterService {
	
	private MemberDao memberDao;

	@Autowired(required=false)
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public MemberRegisterService() {}
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("dup email: " + req.getEmail());
		}
		
		Member newMember = new Member(null, req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}
