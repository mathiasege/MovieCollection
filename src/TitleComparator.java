import java.util.Comparator;

public class TitleComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie m1, Movie m2){
        return m1.getTitle().toLowerCase().compareTo(m2.getTitle().toLowerCase());
    }
}
