package com.mycompany.blueraystore.web.controller;

import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieServiceInterface service;
	
	public Movie displayMovieDetails() {
		return null;
	}
}
