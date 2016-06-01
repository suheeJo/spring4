package com.suhee.basic.ch4.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.suhee.basic.ch4.dao.MemberDao;
import com.suhee.basic.ch4.model.Member;

//@Setter
public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	@Autowired
	public void injectDependency(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.memberPrinter = printer;
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		memberPrinter.print(member);
		System.out.println();
	}
}
