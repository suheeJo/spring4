package com.suhee.basic.ch3.assembler;

import java.util.Collection;

import com.suhee.basic.ch3.dao.MemberDao;
import com.suhee.basic.ch3.model.Member;
import com.suhee.basic.ch3.model.MemberPrinter;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll() {
		Collection<Member> memberList = memberDao.selectAll();
		for (Member member : memberList) {
			memberPrinter.print(member);
		}
	}
}
