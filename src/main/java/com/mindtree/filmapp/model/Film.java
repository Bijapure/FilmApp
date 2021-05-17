package com.mindtree.filmapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int filmId;
	@NotNull
	@Size(min = 3,max = 30,message = "Minimum 3 Character Name Required")
	private String filmName;
	@NotNull
	private String boxOfficeCollection;
	@NotNull
	@Max(5)
	private double filmRating;
	@OneToMany(mappedBy = "film",cascade = CascadeType.ALL)
	List<Director> director;

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Film(int filmId, String boxOfficeCollection, double filmRating, List<Director> director, String filmName) {
		super();
		this.filmId = filmId;
		this.boxOfficeCollection = boxOfficeCollection;
		this.filmRating = filmRating;
		this.director = director;
		this.filmName=filmName;
	}

	public int getFilmId() {
		return filmId;
	}
	
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getBoxOfficeCollection() {
		return boxOfficeCollection;
	}

	public void setBoxOfficeCollection(String boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}

	public double getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(double filmRating) {
		this.filmRating = filmRating;
	}

	public List<Director> getDirector() {
		return director;
	}

	public void setDirector(List<Director> director) {
		this.director = director;
	}

}
