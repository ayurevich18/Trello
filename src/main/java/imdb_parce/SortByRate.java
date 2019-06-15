package imdb_parce;

import java.util.Comparator;

public class SortByRate implements Comparator<Directors> {
    @Override
    public int compare(Directors o1, Directors o2) {
        return (o1.filmRate < o2.filmRate) ? -1 : ((o1.filmRate == o2.filmRate) ? 0 : 1);
    }
}
