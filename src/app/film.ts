import { Director } from "./director";

export class Film {
    filmId?:number
    filmName:string
    boxOfficeCollection:string
    filmRating:number
    director:Director[];
}
