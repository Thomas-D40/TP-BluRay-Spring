package com.mycompany.blueraystore.web.controller;

import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieServiceInterface service;
	
	@GetMapping("/{id}")
	public String displayMovieDetails(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("movie", service.getMovieById(id));
		
		return "movie-details";
	}
	
	@PostMapping
	public String addMovie(@ModelAttribute Movie movie) {
		service.registerMovie(movie);
		return "bluray-added";
	}
	
	
	
	
}
