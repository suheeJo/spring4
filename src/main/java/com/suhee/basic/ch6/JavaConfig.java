package com.suhee.basic.ch6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

	@Bean
	@Scope("prototype")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버3");
		return client2;
	}
}
