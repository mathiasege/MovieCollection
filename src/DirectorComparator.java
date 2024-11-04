import java.util.Comparator;

public class DirectorComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2){
        return m1.getDirector().toLowerCase().compareTo(m2.getDirector().toLowerCase());
    }

}

