package com.mycompany.blueraystore.core.service.defaultservice;

import com.mycompany.blueraystore.core.entity.Movie;
import com.mycompany.blueraystore.core.repository.MovieRepositoryInterface;
import com.mycompany.blueraystore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface {
	
	@Autowired
	private MovieRepositoryInterface repository;
	
	
	public void registerMovie(Movie movie){
		repository.add(movie);
		System.out.println("Le film " + movie.getTitle() + " de genre " + movie.getGenre()+ " a bien été ajouté!");
	};
	
	public MovieRepositoryInterface getRepository() {
		return repository;
	}
	
	public void setRepository(MovieRepositoryInterface repository) {
		this.repository = repository;
	}
	
	@Override
	public Movie getMovieById(long id) {
		return repository.getById(id);
	}
	
	
	@Override
	public List<Movie> getMovieList() {
		return repository.list();
	}
}
