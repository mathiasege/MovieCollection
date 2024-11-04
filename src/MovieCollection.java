import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movieCollection = new ArrayList<Movie>();
    private final String fieldSeperator = ";";

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

    public String getFieldSeperator(){
        return fieldSeperator;
    }

    //TODO: MAKE THIS NON CASE SENSITIVE
    public ArrayList<Movie> searchByTitle(String title){
        ArrayList<Movie> searchResults = new ArrayList<Movie>();
        for(Movie movie: movieCollection){
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())){
                searchResults.add(movie);
            }
        }

        return searchResults;
    }

    //if it finds a copy of the movie it returns true and deletes the movie, otherwise it returns false.
    public boolean deleteMovie(Movie movieToDelete){
        for(Movie m : movieCollection){
            if (m.equals(movieToDelete)){
                movieCollection.remove(movieToDelete);
                return true;
            }
        }
        return false;
    }

    public void saveMovieListToFile() {

        PrintStream movieCollectionFile;
        try{
            movieCollectionFile = new PrintStream("MovieCollection.txt");
            /*for(String name : names){
                namesFile.println(name);
            }*/

        }catch (FileNotFoundException e){
            System.out.println("The file with the movies could not be found");
            return;
        }
        for(Movie m : movieCollection){
            String fileLine = m.getTitle() + fieldSeperator +
                    m.getDirector() + fieldSeperator +
                    m.getYearCreated() + fieldSeperator +
                    m.isInColor() + fieldSeperator +
                    m.getLengthInMinutes() + fieldSeperator +
                    m.getGenre() + fieldSeperator;
            movieCollectionFile.println(fileLine);
        }

        movieCollectionFile.close();

    }

    public void loadCollectionFromFile(){
        File collectionFIle = new File("MovieCollection.txt");
        Scanner sc = null;

        try{
            sc = new Scanner(collectionFIle);
        }catch (FileNotFoundException e){
            System.out.println("ERROR: file not found while trying to load list");
            return;
        }

        movieCollection.clear();
        while(sc.hasNextLine()){
            String fileLine = sc.nextLine();
            String[] fields = fileLine.split(fieldSeperator);
            String title = fields[0];
            String director = fields[1];
            int yearCreated = Integer.parseInt(fields[2]);
            boolean isInColor;
            if(fields[3].equals("true")){
                isInColor = true;
            }else {
                isInColor = false;
            }
            int lengthInMinutes = Integer.parseInt(fields[4]);
            String genre = fields[5];

            Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
            movieCollection.add(movie);

        }
    }


    public void sortCollection(){
        movieCollection.sort(null);
    }

    public void sortCollectionByDirector(){
        movieCollection.sort(new DirectorComparator());
    }

    public void sortCollectionByGenre(){
        movieCollection.sort(new GenreComparator());
    }

    public void sortCollectionByIsInColor(){
        movieCollection.sort(new IsInColorComparator());
    }

    public void sortCollectionByLengthInMinutes(){
        movieCollection.sort(new LengthInMinutesComparator());
    }

    public void sortCollectionByYearCreated(){
        movieCollection.sort(new YearCreatedComparator());
    }

}
