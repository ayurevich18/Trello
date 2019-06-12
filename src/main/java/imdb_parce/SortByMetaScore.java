package imdb_parce;

import java.util.Comparator;

public class SortByMetaScore implements Comparator<FilmPage> {
    @Override
    public int compare(FilmPage o1, FilmPage o2) {
        return (o1.metascore < o2.metascore) ? -1 : ((o1.metascore == o2.metascore) ? 0 : 1);
    }
}
