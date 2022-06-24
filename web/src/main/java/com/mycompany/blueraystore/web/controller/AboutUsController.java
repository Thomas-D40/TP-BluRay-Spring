package com.mycompany.blueraystore.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutUsController {
	
	@RequestMapping(value = "/about-us", method = RequestMethod.GET)
	public ModelAndView displayAboutUs() {
		System.out.println("La page about us a été affichée");
		return new ModelAndView();

	}
}
