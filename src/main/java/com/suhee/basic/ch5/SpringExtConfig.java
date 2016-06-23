package com.suhee.basic.ch5;

import org.springframework.context.annotation.Bean;

public class SpringExtConfig extends JavaConfig {
	
	private MemberDao memberDaoBean;
	@Bean
	public MemberDao memberDao() {
		if(memberDaoBean == null) {
//			memberDaoBean = super.memberDao();
		}
		return memberDaoBean;
	}
	
	private MemberRegisterService memberRegisterServiceBean;
	@Bean
	public MemberRegisterService memberRegisterService() {
		if(memberRegisterServiceBean == null) {
			memberRegisterServiceBean = super.memberRegisterService();
		}
		return memberRegisterServiceBean;
	}
	
	private MemberInfoPrinter infoPrinterBean;
	@Bean
	public MemberInfoPrinter infoPrinter() {
		if(infoPrinterBean == null) {
//			infoPrinterBean = super.infoPrinter();
		}
		return infoPrinterBean;
	}
}
