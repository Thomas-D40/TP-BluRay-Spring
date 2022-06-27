package com.mycompany.blueraystore.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieForm {
	@NotBlank(message = "Veuillez entrer un titre")
	@Size(max = 20, message = "Veuillez entre un titre de 20 caractères maximum")
	private String title;
	@NotBlank(message = "Veuillez choisir un genre")
	private String genre;
	@Size(max = 255, message = "Veuillez entrer une description de 255 caractères maximum")
	private String description;
	
	public MovieForm() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
