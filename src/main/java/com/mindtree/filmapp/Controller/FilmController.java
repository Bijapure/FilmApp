package com.mindtree.filmapp.Controller;

import java.util.List;

import javax.sound.midi.InvalidMidiDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.filmapp.model.Director;
import com.mindtree.filmapp.model.Film;
import com.mindtree.filmapp.service.FilmDirectorService;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class FilmController {

	@Autowired
	FilmDirectorService filmDirectorService;
	
	@PostMapping("/addfilmwithdirector")
	public void addFilmWithDirector(@RequestBody Film film)
	{
		this.filmDirectorService.saveFilmAndDirector(film);
	}
	
	@GetMapping("/getfilmwithdirector")
	public List<Film> getFilmWithDirector(){
		
		return this.filmDirectorService.getAllFilmAndDirectorRecord();
	}
	
	@DeleteMapping("/deletefilmbyname")//deletefilmbyname?filmName=Happy
	public String findByfilmName(@RequestParam String filmName)
	{
		this.filmDirectorService.deleteFilmAByName(filmName);
		return "Deleted Film: "+filmName;
	}
	
	@PutMapping("/updatedirector")
	public void updateDirector(@RequestBody Director dic)
	{
		this.filmDirectorService.updateDirectorDetail(dic);
	}
	
	@GetMapping("/getDirectorsList")
	public List<Director> getAllDirector()
	{
		return this.filmDirectorService.getAllDirectorRecord();
	}
}

