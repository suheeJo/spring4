package com.suhee.basic.ch9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(
		@RequestParam(value="name", required=false) String name
		, Model model) {
		
		model.addAttribute("greeting", "안녕하세요, " + name);
		
		return "hello";		
	}
}
