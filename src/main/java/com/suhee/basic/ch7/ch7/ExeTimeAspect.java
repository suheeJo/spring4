package com.suhee.basic.ch7.ch7;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		
		try {
			Object result = joinPoint.proceed();
			return result;
		}finally {
			long end = System.currentTimeMillis();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 = %d\n"
					, joinPoint.getTarget().getClass().getSimpleName()
					, sig.getName()
					, Arrays.toString(joinPoint.getArgs())
					, (end - start));
		}
	}
}
