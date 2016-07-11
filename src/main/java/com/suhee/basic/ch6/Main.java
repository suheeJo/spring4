package com.suhee.basic.ch6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Client.setHost() 실행
		// Client.afterPropertiesSet() 실행
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		Client2 client = ctx.getBean("client2", Client2.class);
		// Client.send() to 서버2
		client.send();
		// Client.destory() 실행
		ctx.close();
	}
}
