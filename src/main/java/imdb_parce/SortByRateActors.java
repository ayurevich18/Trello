package imdb_parce;

import java.util.Comparator;

public class SortByRateActors implements Comparator<Actors> {
    @Override
    public int compare(Actors o1, Actors o2) {
        return (o1.filmRate < o2.filmRate) ? -1 : ((o1.filmRate == o2.filmRate) ? 0 : 1);
    }
}
