package com.mindtree.filmapp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.filmapp.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer>{

	Director findBydirectorName(String directorName);
}
