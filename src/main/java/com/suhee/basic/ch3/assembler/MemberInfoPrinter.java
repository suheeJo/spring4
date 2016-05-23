package com.suhee.basic.ch3.assembler;

import com.suhee.basic.ch3.dao.MemberDao;
import com.suhee.basic.ch3.model.Member;
import com.suhee.basic.ch3.model.MemberPrinter;

import lombok.Setter;

@Setter
public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
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
