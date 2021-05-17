import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Film } from './film';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(private http:HttpClient) { }

  API="http://localhost:8080";

  public addFilmAndDirectors(addfilm)
  {
    return this.http.post<Film>(this.API+'/addfilmwithdirector',addfilm);
  }

  public displayAllFilm(){
    return this.http.get(this.API+'/getfilmwithdirector');
  }

  public deleteFilm(filmName){
     return this.http.delete(this.API+'/deletefilmbyname?filmName='+filmName);
   }

  public updateDirector(director)
  {
    return this.http.put(this.API+'/updatedirector',director);
  }

  public getAllDirectors()
  {
    return this.http.get(this.API+'/getDirectorsList');
  }
  
}
