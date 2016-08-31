package com.suhee.basic.ch11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/member/login", method=RequestMethod.GET)
	public String form() {
		return "/member/login";
	}
	
	@RequestMapping(value = "/member/login", method=RequestMethod.POST)
	public String login() {
		return "";
	}
}
