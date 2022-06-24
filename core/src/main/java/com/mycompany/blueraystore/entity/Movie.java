package com.mycompany.blueraystore.entity;


public class Movie {
	private String title;
	private String genre;
	
	public Movie() {
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Movie{");
		sb.append("title='").append(title).append('\'');
		sb.append(", genre='").append(genre).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
