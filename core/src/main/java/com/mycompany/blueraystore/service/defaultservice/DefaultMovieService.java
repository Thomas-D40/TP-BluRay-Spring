package com.mycompany.blueraystore.service.defaultservice;

import com.mycompany.blueraystore.repository.MovieRepositoryInterface;
import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.service.MovieServiceInterface;
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
	public List<Movie> getMovieList() {
		return repository.list();
	}
}
