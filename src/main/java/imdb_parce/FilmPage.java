package imdb_parce;

import java.util.List;

public class FilmPage implements Comparable {
    public String filmName;
    public double rating;
    public String director;
    public int metascore;
    public int year;
    public List<String> actors;
    public String genres;
    public int runtime;
    public String urlDirector;


    public FilmPage(String filmName, double rating,String director,int metascore,int year,List<String> actors,String genres, int runtime,String urlDirector){
        this.filmName=filmName;
        this.rating=rating;
        this.director=director;
        this.metascore=metascore;
        this.year=year;
        this.actors=actors;
        this.genres=genres;
        this.runtime=runtime;
        this.urlDirector=urlDirector;

    }

    @Override
    public String toString() {
        return "FilmPage{" +
                "filmName='" + filmName + '\'' +
                ", rating=" + rating +
                ", director='" + director + '\'' +
                ", metascore=" + metascore +
                ", year=" + year +
                ", actors='" + actors + '\'' +
                ", genres='" + genres + '\'' +
                ", runtime=" + runtime +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        FilmPage f=(FilmPage)o;
        return (runtime < f.runtime) ? -1 : ((runtime == f.runtime) ? 0 : 1);
    }
}
