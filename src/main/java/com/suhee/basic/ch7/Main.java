package com.suhee.basic.ch7;

public class Main {

	public static void main(String[] args) {
		/*
		ImpeCalculator impeCal = new ImpeCalculator();
		long start1 = System.currentTimeMillis();
		impeCal.factorial(5);
		long end1 = System.currentTimeMillis();
		System.out.printf("ImpeCalculator.factorial(5) 실행시간 = %d\n", (end1-start1));
		
		RecCalculator recCal = new RecCalculator();
		long start2 = System.currentTimeMillis();
		recCal.factorial(5);
		long end2 = System.currentTimeMillis();
		System.out.printf("RecCalculator.factorial(5) 실행시간 = %d\n", (end2-start2));
		*/
		
		/*
		ImpeCalculator impeCal = new ImpeCalculator();
		ExeTimeCalculator calculator = new ExeTimeCalculator(impeCal);
		long result1 = calculator.factorial(5);
		*/
		
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));
		
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));
	}

}
