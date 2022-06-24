package com.mycompany.blueraystore.repository.file;

import com.mycompany.blueraystore.entity.Movie;
import com.mycompany.blueraystore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class FileMovieRepository implements MovieRepositoryInterface {
	@Value("${movies.file.location}")
	private File file;
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void add(Movie movie) {
		FileWriter writer;
		try {
			
			writer = new FileWriter(file, true);
			writer.write(String.format("%s;%s\n", movie.getTitle(), movie.getGenre()));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Movie> list() {
		List<Movie> movies=new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null; ) {
				final Movie movie=new Movie();
				final String[] titreEtGenre = line.split("\\;");
				movie.setTitle(titreEtGenre[0]);
				movie.setGenre(titreEtGenre[1]);
				movies.add(movie);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movies;
	}
	}
	
	
	
		

