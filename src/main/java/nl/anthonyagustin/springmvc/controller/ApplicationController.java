package nl.anthonyagustin.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {
	
	private static Logger LOG = LoggerFactory.getLogger(ApplicationController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		LOG.info("Loading the Homepage");
		return "welcome";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profilePage(ModelMap model) {
		LOG.info("Loading the profile page");
		return "profile";
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String messagesPage(ModelMap model) {
		LOG.info("Loading the messages page");
		return "messages";
	}
}