package imdb_parce;

import java.util.Comparator;

public class SortByYear implements Comparator<FilmPage> {
    @Override
    public int compare(FilmPage o1, FilmPage o2) {
        return (o1.year < o2.year) ? -1 : ((o1.year == o2.year) ? 0 : 1);
    }
}
