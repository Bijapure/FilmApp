package com.mindtree.filmapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.filmapp.Exception.InvalidDataException;
import com.mindtree.filmapp.Repo.DirectorRepository;
import com.mindtree.filmapp.Repo.FilmRepository;
import com.mindtree.filmapp.model.Director;
import com.mindtree.filmapp.model.Film;

@Service
public class FilmDirectorService {

	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	DirectorRepository directorRepo;

	public void saveFilmAndDirector(Film film) {
		Film f=filmRepo.findByfilmName(film.getFilmName());
		List<Director> dic= directorRepo.findAll();
		List<Director> d=film.getDirector();
		for(Director d1:d)
		{
			d1.setFilm(film);
		}
		if(f==null) {
			
			filmRepo.save(film);
		
		}
		else
		{
			//f.getDirector().addAll(film.getDirector());
			System.out.println(f.getFilmName());
			
			filmRepo.save(f);
			//directorRepo.saveAll(film.getDirector());
		}
	}

	public List<Film> getAllFilmAndDirectorRecord() {
		return (List<Film>) filmRepo.findAll();
	}

	public void deleteFilmAByName(String filmName){
		Film f=filmRepo.findByfilmName(filmName);
		if(f==null)
		{
			throw new InvalidDataException("No Record Found With This Name !!!!");
		}
		List<Director> dList=f.getDirector();
		filmRepo.deleteById(f.getFilmId());
		
		for(Director d:dList)
			d.setFilm(null);
		directorRepo.saveAll(dList);
		
	}

	public void updateDirectorDetail(Director dic){
		Director d=directorRepo.findBydirectorName(dic.getDirectorName());
		if(d.equals(dic))
		{
			throw new InvalidDataException("Same Record Updated !!!!");
		}else if(d!=null) {
		d.setAwardCount(dic.getAwardCount());
		d.setDirectorAge(dic.getDirectorAge());
		directorRepo.save(d);
		}
	}

	public List<Director> getAllDirectorRecord() {
		return directorRepo.findAll();
	}
	
}
