package com.mindtree.filmapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "director_id")
	private int directorId;
	@NotNull
	@Column(unique = true)
	@Size(min = 3,max = 30,message = "Minimum 3 Character Name Required")
	private String directorName;
	@NotNull
	@Min(18)
	private int directorAge;
	@NotNull
	private String directorGender;
	@NotNull
	private int awardCount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Film film;
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Director(int directorId, String directorName, int directorAge, String directorGender, int awardCount) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.directorAge = directorAge;
		this.directorGender = directorGender;
		this.awardCount = awardCount;
	}
	
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public int getDirectorId() {
		return directorId;
	}
	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public int getDirectorAge() {
		return directorAge;
	}
	public void setDirectorAge(int directorAge) {
		this.directorAge = directorAge;
	}
	public String getDirectorGender() {
		return directorGender;
	}
	public void setDirectorGender(String directorGender) {
		this.directorGender = directorGender;
	}
	public int getAwardCount() {
		return awardCount;
	}
	public void setAwardCount(int awardCount) {
		this.awardCount = awardCount;
	}
	
	
}
