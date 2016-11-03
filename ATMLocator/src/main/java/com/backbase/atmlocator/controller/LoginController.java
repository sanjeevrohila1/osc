package com.backbase.atmlocator.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
			logger.info("Invalid Credentials!");
		}
		if (logout != null) {
			model.addObject("message", "Logged out from ATM Locator App successfully.");
			logger.info("User Logged out successfully!");
		}
		model.setViewName("loginPage");
		return model;
	}

}
