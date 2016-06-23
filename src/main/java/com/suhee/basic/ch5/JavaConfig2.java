package com.suhee.basic.ch5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig2 {

	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setMemberPrinter(memberPrinter());
		return infoPrinter;
	}
}
