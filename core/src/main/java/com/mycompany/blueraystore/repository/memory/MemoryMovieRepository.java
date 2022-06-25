package com.mycompany.blueraystore.repository.memory;

import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepository implements MovieRepositoryInterface {
	
	public static List<Movie> movies = new ArrayList<>();
	
	public void add(Movie movie) {
		movies.add(movie);
		
	}
	@Override
	public List<Movie> list(){
		return movies;
	}
	
	@Override
	public Movie getById(long id) {
		return movies.stream().
				filter(m -> m.getId()==id).
				findFirst().get();
	}
	
	
}
