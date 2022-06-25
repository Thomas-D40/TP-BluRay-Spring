package com.mycompany.blueraystore.repository;

import com.mycompany.blueraystore.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {
	public void add(Movie movie);
	
	public List<Movie> list();
	
	public Movie getById(long id);
}
