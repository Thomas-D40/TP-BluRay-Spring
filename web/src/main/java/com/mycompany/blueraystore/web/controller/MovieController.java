package com.mycompany.blueraystore.web.controller;

import com.mycompany.blueraystore.core.entity.Movie;
import com.mycompany.blueraystore.core.service.MovieServiceInterface;
import com.mycompany.blueraystore.web.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieServiceInterface service;
	
	@GetMapping("/{id}")
	public String displayMovieDetails(@PathVariable("id") long id, MovieForm movieForm) {
		
		return "movie-details";
	}
	
	@PostMapping
	public String addMovie(@Valid MovieForm movieForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-bluray-form";
		}
		Movie movie = new Movie();
		movie.setTitle(movieForm.getTitle());
		movie.setGenre(movieForm.getGenre());
		movie.setDescription(movieForm.getDescription());
 
		service.registerMovie(movie);
		return "bluray-added";
	}
	
	
	
	
}
