package imdb_parce;

import java.util.Comparator;

public class SortByRuntime implements Comparator<FilmPage> {
    @Override
    public int compare(FilmPage o1, FilmPage o2) {
        return (o1.runtime < o2.runtime) ? -1 : ((o1.runtime == o2.runtime) ? 0 : 1);
    }
}
