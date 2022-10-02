package com.blaldas.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blaldas.flightreservation.entities.User;
import com.blaldas.flightreservation.repos.UserRepostory;
import com.blaldas.flightreservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	private UserRepostory userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder; 
	
	@Autowired
	private SecurityService securityService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("inside showRegistrationPage");		
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		
		LOGGER.info("inside showLoginPage");		
		return "login/login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		LOGGER.info("inside register " + user);		

		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
	
		LOGGER.info("inside login " + email);		
	
	
		if (securityService.login(email, password))
			return "findFlights";
		else
			modelMap.addAttribute("msg", "Invalid Username or Password. Please try again");
		return "login/login";
	}

}
