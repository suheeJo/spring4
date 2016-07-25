package com.suhee.basic.ch7.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.suhee.basic.ch7.ch7.Calculator;
import com.suhee.basic.ch7.config.JavaConfig;

public class MainJavaAspect {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);

		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long fiveFact = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = " + fiveFact);
	}
}
