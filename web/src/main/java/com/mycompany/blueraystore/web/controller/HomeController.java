package com.mycompany.blueraystore.web.controller;


import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.service.MovieServiceInterface;
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
	
	
	@GetMapping("/add-bluray-form")
	public void displayMovieForm(Model model) {
		model.addAttribute("movie", new Movie());
	}
	
	
	
}
