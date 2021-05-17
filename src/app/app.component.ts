import { Component } from '@angular/core';
import { Director } from './director';
import { Film } from './film';
import { FilmService } from './film.service';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[NgbRatingConfig]
})
export class AppComponent {
  title = 'filmApp';

  
  updateOnlyDirectorDetail= {
    "directorName": "",
    "directorAge":null,
    "directorGender": null,
    "awardCount": 1
  };//for updation
  b = [] as any;
  
  films = null;
  directorslist=null;
  directorsRecords=null;  //for seprate displaying directors records only.
  director = {
    "directorName": "",
    "directorAge":null,
    "directorGender": null,
    "awardCount": 1
  };


  constructor(private filmSerice: FilmService,config: NgbRatingConfig) {
    this.getAllRecords();
    this.getAllDirectorsRecord();
    config.max=5;
  }



  public addMoredirector() {
    var directorname = (<HTMLInputElement>document.getElementById("directorName")).value;
    var directorgender = (<HTMLInputElement>document.getElementById("directorGender")).value;
    const awardcount = +(<HTMLInputElement>document.getElementById("awardCount")).value;
    const directorage = (<HTMLInputElement>document.getElementById("directorAge")).value;

    console.log(directorname + " " + directorage + " " + awardcount+ " "+directorgender);
    // this.director.directorName=directorname;
    // this.director.directorAge=directorage;
    // this.director.directorGender=directorgender;
    // this.director.awardCount=awardcount;

    this.director = { directorName: directorname, directorAge: directorage, directorGender: directorgender, awardCount: awardcount };
    this.b.push(this.director);
    return this.b;
  }

  register(registerFilmform: Film) {
    console.log(registerFilmform);
    registerFilmform.director = this.b;
    this.filmSerice.addFilmAndDirectors(registerFilmform).subscribe(
      (resp) => {
        console.log(resp);
        this.b.pop();
        this.getAllRecords();
        this.getAllDirectorsRecord();
        registerFilmform=null;
      },
      error => {
        console.log(error);
      }
    );

  }


  getAllRecords() {
    this.filmSerice.displayAllFilm().subscribe(
      (resp: Film[]) => {
        this.films = resp;
        console.log(resp);
      },
      err => {
        console.log(err);
      }
    );
  }

  public getAllDirectorsRecord(){
    this.filmSerice.getAllDirectors().subscribe(
      res=>{
        console.log(res);
        this.directorsRecords=res;
      },
      er=>{console.log(er)}
    );
  }


  public viewAllDirector(dir: Film) {
    this.directorslist = dir.director;
    // console.log(this.catBooks.books.bookName);
  }
  deleteFilm(f:Film){
    this.filmSerice.deleteFilm(f.filmName).subscribe(
      res=>{console.log(res);},
      err=>{console.log(err);}
    );
  }
  updateDirectorDetail(direct_Details)
  {
    this.updateOnlyDirectorDetail=direct_Details;
  }

  updateDirectorAgeAward()
  {
    console.log(this.updateOnlyDirectorDetail)
    this.filmSerice.updateDirector(this.updateOnlyDirectorDetail).subscribe(
      res=>{console.log(res)},
      er=>{console.log(er)}
    );
  }
}
