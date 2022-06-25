package com.mycompany.blueraystore.service;

import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.repository.MovieRepositoryInterface;

import java.util.List;

public interface MovieServiceInterface {
	public void registerMovie(Movie movie);
	public List<Movie> getMovieList();
	
	public void setRepository(MovieRepositoryInterface repositoryInterface);
	
	public Movie getMovieById(long id);
}
