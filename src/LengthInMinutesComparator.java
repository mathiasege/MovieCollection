import java.util.Comparator;

public class LengthInMinutesComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2){
        return Integer.compare(m1.getLengthInMinutes(), m2.getLengthInMinutes());
    }
}
