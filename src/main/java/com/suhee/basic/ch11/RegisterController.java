package com.suhee.basic.ch11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.suhee.basic.ch3.model.RegisterRequest;

@Controller
public class RegisterController {
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";		
	}
	
	@RequestMapping(value = "/register/step2", method = RequestMethod.POST)
	public String handleStep2(
		@RequestParam(value="agree", defaultValue="false") Boolean agreeVal
		, Model model) {
		
		if(!agreeVal) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
	@RequestMapping(value = "/register/step2", method = RequestMethod.GET)
	public String handleStep2Get(
		@RequestParam(value="agree", defaultValue="false") Boolean agreeVal) {
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value = "register/step3", method = RequestMethod.POST)
	public String handleStep3(RegisterRequest regReq) {
		try {
//			return "register/step2";
			return "register/step3";
		}catch(AlreadyExistingMemberException ex) {
			return "register/step2";
		}
	}
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("test", "data");
		mav.setViewName("test/data");
		return mav;
	}
}