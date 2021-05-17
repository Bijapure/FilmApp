package com.mindtree.filmapp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.filmapp.model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer>{

	Film findByfilmName(String filmName);
}
