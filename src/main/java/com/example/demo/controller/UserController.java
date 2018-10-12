package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Modal.User;
import com.example.demo.repository.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView model = new ModelAndView();

		model.setViewName("user/login");

		return model;

	}

	@RequestMapping(value = { "/", "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {

		ModelAndView model = new ModelAndView();

		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/signup");
		return model;

	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {

		ModelAndView model = new ModelAndView();
		User userExists = userService.findByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "email already exists");

		}
		if (bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			userService.saveUser(user);
			model.addObject("msg", "user has been succesfully saved");
			model.addObject("use", new User());
			model.setViewName("user/signup");
		}

		return model;

	}

	@RequestMapping(value = { "/home/home" }, method = RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());

		model.addObject("userName" + user.getUsername() + user.getName());
		model.setViewName("home/home");
		return model;

	}

	@RequestMapping(value = { "access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();

		model.setViewName("errors/access_denied");
		return model;
	}
}
