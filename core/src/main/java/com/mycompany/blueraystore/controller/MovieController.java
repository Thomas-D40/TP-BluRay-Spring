package com.mycompany.blueraystore.controller;

import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {
	
	@Autowired
	private MovieServiceInterface service;
	
	// public MovieRepositoryInterface interface;
	
	
	
	public void addUsingConsole() {

		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Quel est le titre du film?");
		String title = scan.nextLine();
		System.out.println("Quel est le genre?");
		String genre = scan.nextLine();
		
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setGenre(genre);
		
		service.registerMovie(movie);
		
	}
	
	public MovieServiceInterface getService() {
		return service;
	}
	
	public void setService(MovieServiceInterface service) {
		this.service = service;
	}
}
