package com.mycompany.blueraystore.core.service;

import com.mycompany.blueraystore.core.entity.Movie;
import com.mycompany.blueraystore.core.repository.MovieRepositoryInterface;

import java.util.List;

public interface MovieServiceInterface {
	public void registerMovie(Movie movie);
	public List<Movie> getMovieList();
	
	public void setRepository(MovieRepositoryInterface repositoryInterface);
	
	public Movie getMovieById(long id);
}
