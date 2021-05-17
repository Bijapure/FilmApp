package com.mindtree.filmapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*{
    "filmName":"Harry Potter",
    "boxOfficeCollection":"255.5 Crore",
    "filmRating":4.5,
    "director":[{

            "directorName":"P K Master",
            "directorAge":43,
            "directorGender":"Male",
            "awardCount":5
    },
    {

            "directorName":"M Baskar",
            "directorAge":43,
            "directorGender":"Male",
            "awardCount":5
    }]
    

}*/
@SpringBootApplication
public class FilmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmAppApplication.class, args);
	}

}
