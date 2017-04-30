package com.epam.cinema.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class StartController {

	@RequestMapping(value = { "", "/", "/start" }, method = { RequestMethod.GET })
	public ModelAndView login(HttpSession session) {

		ModelAndView model = new ModelAndView();
		model.setViewName("start");
		return model;
	}

}
