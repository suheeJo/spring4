package com.suhee.basic.ch4.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {	
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext4.xml");
	}
}
