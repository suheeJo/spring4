package com.suhee.basic.ch5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail("shjo@a.com");
		request.setName("shjo");
		request.setPassword("123");
		request.setConfirmPassword("123");

		registerService.regist(request);
		
		infoPrinter.printMemberInfo("shjo@a.com");
	}

}
