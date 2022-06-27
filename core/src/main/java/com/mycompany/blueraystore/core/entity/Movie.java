package com.mycompany.blueraystore.core.entity;


public class Movie {
	
	private Long id;
	
	private String description;
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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Movie{");
		sb.append("id=").append(id);
		sb.append(", description='").append(description).append('\'');
		sb.append(", title='").append(title).append('\'');
		sb.append(", genre='").append(genre).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
