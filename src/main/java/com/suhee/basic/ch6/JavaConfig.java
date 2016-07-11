package com.suhee.basic.ch6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean()
	public Client client() {
		Client client = new Client();
		client.setHost("서버2");
		return client;
	}
}
