package com.suhee.basic.ch7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.suhee.basic.ch7.ch7.Calculator;
import com.suhee.basic.ch7.ch7.ExeTimeAspect2;
import com.suhee.basic.ch7.ch7.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
	
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator recCal() {
		return new RecCalculator();
	}
}
