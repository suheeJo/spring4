package com.suhee.basic.ch3.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.suhee.basic.ch3.assembler.MemberInfoPrinter;
import com.suhee.basic.ch3.assembler.MemberListPrinter;
import com.suhee.basic.ch3.assembler.VersionPrinter;
import com.suhee.basic.ch3.exception.AlreadyExistingMemberException;
import com.suhee.basic.ch3.exception.IdPasswordNotMatchingException;
import com.suhee.basic.ch3.exception.MemberNotFoundException;
import com.suhee.basic.ch3.model.RegisterRequest;
import com.suhee.basic.ch3.service.MemberRegisterService;
import com.suhee.basic.ch3.service.UpdatePasswordService;

public class XMLMain {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
//		ctx = new GenericXmlApplicationContext("classpath:applicationContext3.xml");
		String[] conf = {"classpath:conf1.xml", "classpath:conf2.xml"};
		ctx = new GenericXmlApplicationContext(conf);
//		ctx = new GenericXmlApplicationContext("classpath:conf1.xml", "classpath:conf2.xml");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요: ");
			String command = br.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("update ")) {
				processUpdateCommand(command.split(" "));
				continue;
			}else if(command.startsWith("list")) {
				processListCommand();
				continue;
			}else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			}else if(command.startsWith("version")) {
				processVersionCommand();
				continue;
			}
			
			printHelp();
		}
	}
	
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService memberRegisterService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEmail(args[1]);
		registerRequest.setName(args[2]);
		registerRequest.setPassword(args[3]);
		registerRequest.setConfirmPassword(args[4]);
		
		if(!registerRequest.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다. \n");
			return;
		}
		
		try {
			memberRegisterService.regist(registerRequest);
			System.out.println("등록했습니다.\n");
		}catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	
	private static void processUpdateCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		UpdatePasswordService updatePasswordService = ctx.getBean("updatePasswordService", UpdatePasswordService.class);
		
		try {
			updatePasswordService.updatePassword(args[1], args[2], args[3]);
			System.out.println("암호를 변경했습니다.\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("version");
		System.out.println();
	}
	
	private static void processListCommand() {
		MemberListPrinter memberListPrinter = ctx.getBean("memberListPrinter", MemberListPrinter.class);
		memberListPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] args) {
		if(args.length != 2) {
			printHelp();
			return;
		}
		
		MemberInfoPrinter memberInfoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(args[1]);
	}
	
	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
}
