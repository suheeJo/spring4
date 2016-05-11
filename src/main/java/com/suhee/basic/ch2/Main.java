package com.suhee.basic.ch2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("g1 == g2: " + (g1 == g2));
		
		Greeter g3 = ctx.getBean("greeter2", Greeter.class);
		System.out.println("g1 == g3: " + (g1 == g3));
		
		ctx.close();
	}

}
