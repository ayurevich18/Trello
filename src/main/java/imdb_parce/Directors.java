package imdb_parce;

public class Directors  {
    public String directorName;
    public Double filmRate;
    public String filmName;

    public Directors(String directorName, Double filmRate) {
        this.directorName = directorName;
        this.filmRate = filmRate;

    }

    @Override
    public String toString() {
        return "Directors{" +
                "directorName='" + directorName + '\'' +
                ", filmRate=" + filmRate +
                '}';
    }
}
