package com.suhee.basic.ch7.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.suhee.basic.ch7.ch7.Calculator;
import com.suhee.basic.ch7.ch7.ImpeCalculator;

public class MainXMlPojo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch7-config.xml");
		
		Calculator impeCal = ctx.getBean("impeCal", ImpeCalculator.class);
		long fiveFact1 = impeCal.factorial(5);
		System.out.println("impeCal.factorial(5): " + fiveFact1);
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long fiveFact2 = recCal.factorial(5);
		System.out.println("recCal.factorial(5): " + fiveFact2);
	}
}
