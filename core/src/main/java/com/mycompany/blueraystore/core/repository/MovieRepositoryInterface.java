package com.mycompany.blueraystore.core.repository;

import com.mycompany.blueraystore.core.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {
	public void add(Movie movie);
	
	public List<Movie> list();
	
	public Movie getById(long id);
}
