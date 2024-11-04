import java.util.Comparator;

public class YearCreatedComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2){
       return Integer.compare(m1.getYearCreated(), m2.getYearCreated());
    }
}
