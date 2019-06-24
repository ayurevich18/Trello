package imdb_parce;

public class Actors {
    public String actors;
    public Double filmRate;

    public Actors(String actors, Double filmRate) {
        this.actors = actors;
        this.filmRate = filmRate;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "actors='" + actors + '\'' +
                ", filmRate='" + filmRate + '\'' +
                '}';
    }
}
