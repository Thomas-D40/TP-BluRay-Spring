package com.mycompany.blueraystore.web.controller;


import com.mycompany.blueraystore.core.entity.Movie;
import com.mycompany.blueraystore.core.service.MovieServiceInterface;
import com.mycompany.blueraystore.web.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	private MovieServiceInterface service;
	
	// Version améliorée par Samih
	@RequestMapping("/bluraystore-home")
	public @ModelAttribute("movies") List<Movie> displayHome() {
		return service.getMovieList();
	}
	
	@RequestMapping("/home")
	public String displayHomeV2(Model model) {
		model.addAttribute("movies", service.getMovieList());
		return "bluraystore-home";
	}
	
	@GetMapping("/add-bluray-form")
	public void displayMovieForm(Model model, MovieForm movieForm) {
		model.addAttribute("movie", new Movie());
	}
	
	
	
}
