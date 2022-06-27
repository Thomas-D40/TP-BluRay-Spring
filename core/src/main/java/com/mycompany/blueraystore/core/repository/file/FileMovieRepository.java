package com.mycompany.blueraystore.core.repository.file;

import com.mycompany.blueraystore.core.entity.Movie;
import com.mycompany.blueraystore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public class FileMovieRepository implements MovieRepositoryInterface {
	@Value("${movies.file.location}")
	private File file;
	
	private long lastId = 0;

	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void add(Movie movie) {
		FileWriter writer;
		try {
			
			lastId=list().stream().map(Movie::getId).max(Long::compare).orElse(0L);
			movie.setId(lastId+1);
			writer = new FileWriter(file, true);
			writer.write(String.format("%d;%s;%s;%s\n", movie.getId(), movie.getTitle(), movie.getGenre(), movie.getDescription()));
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
				System.out.println(line);
				System.out.println(Arrays.toString(titreEtGenre));
				movie.setId(Long.parseLong(titreEtGenre[0]));
				movie.setTitle(titreEtGenre[1]);
				movie.setGenre(titreEtGenre[2]);
				movie.setDescription(titreEtGenre[3]);
				movies.add(movie);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	@Override
	public Movie getById(long id) {
		
			final Movie movie = new Movie();
			movie.setId(id);
			try(BufferedReader br = new BufferedReader(new FileReader(file))) {
				for(String line; (line = br.readLine()) != null; ) {
					final String[] allProperties = line.split("\\;");
					final long nextMovieId=Long.parseLong(allProperties[0]);
					if (nextMovieId==id) {
						movie.setTitle(allProperties[1]);
						movie.setGenre(allProperties[2]);
						movie.setDescription(allProperties[3]);
						return movie;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.err.println("A movie from the file does not have a proper id");
				e.printStackTrace();
			}
			movie.setTitle("UNKNOWN");
			movie.setGenre("UNKNOWN");
			movie.setDescription("UNKNOWN");
			return movie;
	}
}
	
	
	
		

