import java.util.ArrayList;
import java.util.Comparator;

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

    public boolean deleteMovie(Movie movieToDelete){
        return movieCollection.deleteMovie(movieToDelete);
    }

    public void saveCollection(){
        movieCollection.saveMovieListToFile();
    }

    public void loadCollection(){
        movieCollection.loadCollectionFromFile();
    }

    public String  getFieldSeperator(){
        return movieCollection.getFieldSeperator();
    }

    public void sortCollection(){
        movieCollection.sortCollection();
    }

   /* public void sortCollectionByDirector(String choice1, String choice2){

        Comparator<Movie> test = Comparator.comparing(movieCollection.sortCollectionByDirector(choice1));
        Comparator<Movie> test2 = Comparator.comparing(movieCollection.sortCollectionByDirector(choice2));

        movieCollection.getMovieCollection().sort(test.thenComparing(test2));
    }
    */

    public void sortCollectionByDirector(){
        movieCollection.sortCollectionByDirector();
  }
    public void sortCollectionByGenre(){
        movieCollection.sortCollectionByGenre();
    }
    public void sortCollectionByIsInColor(){
        movieCollection.sortCollectionByIsInColor();
    }
    public void sortCollectionByLengthInMinutes(){
        movieCollection.sortCollectionByLengthInMinutes();
    }
    public void sortCollectionByYearCreated(){
        movieCollection.sortCollectionByYearCreated();
    }

}
