import java.util.ArrayList;

public class Controller {
    private MovieCollection movieCollection = new MovieCollection();

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre){
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    public ArrayList<String> displayAllMovies(){
        ArrayList<String> displayList = movieCollection.displayAllMovies();
        return displayList;
    }

    public ArrayList<Movie> searchByTitle(String title){
        ArrayList<Movie> searchResults = movieCollection.searchByTitle(title);
        return searchResults;
    }

}
