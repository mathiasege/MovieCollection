import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieCollection = new ArrayList<Movie>();

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre){
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movieCollection.add(movie);
    }

    public ArrayList<String> displayAllMovies(){
        ArrayList<String> displayList = new ArrayList<String>();
        for(Movie movie : movieCollection){
            displayList.add(movie.toString());
        }

        return displayList;
    }

    public ArrayList<Movie> getMovieCollection(){
        return movieCollection;
    }

    //TODO: MAKE THIS NON CASE SENSITIVE
    public ArrayList<Movie> searchByTitle(String title){
        ArrayList<Movie> searchResults = new ArrayList<Movie>();
        for(Movie movie: movieCollection){
            if (movie.getTitle().contains(title)){
                searchResults.add(movie);
            }
        }

        return searchResults;
    }

}
