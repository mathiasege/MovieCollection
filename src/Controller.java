import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    // Opbygger min string med movies.
    public String displayMovie() {
        String display = "";

        // gennemgår liste og tilføjer
        for (Movie movie : movieCollection.getMovies()) {
            display += "\n" + movie.toString();
        }

        // If display.isEmpty(){
        // return "No movies exist"
        //} else{
        // return display
        //}
        return display.isEmpty()
                ? "No movies exist."
                : display;
    }



    // Tilføjer
    public String addMovie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);

        // Returner tilføjet.
        return movieCollection.getCurrentMovie();
    }


    public String searchMovie(String searchWord){
        boolean movieMatch = false;
        for(Movie m : movieCollection.getMovies()){
            if(m.getTitle().toLowerCase().contains(searchWord.toLowerCase())){
                movieMatch = true;
                System.out.println(m + "\n");
            }

        }
        return  movieMatch ? "" : "No match found";
    }

    public String deleteMovie(String movieName) {
        // Finder film.
        String movieCheck = checkSpecificMovie(movieName);
        if(!movieCheck.isEmpty()){
            return movieCheck;
        }

        // Fjern.
        movieCollection.deleteMovie();
        return "You removed:\n" + movieCollection.getCurrentMovie();

    }

    // Checker om en film eksistere.
    public String checkSpecificMovie(String movie) {
        try {
            movieCollection.findSpecificMovie(movie);
        } catch (NullPointerException npe) {
            return "The movie doesn't exist";
        }
        return "";
    }

    //search for a film by title:
    public String searchByTitle(String searchTerm){
        String temp = "";
        for(Movie movie : movieCollection.getMovies()){
            if(movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())){
                temp += movie.toString();
            }
        }
        if(temp.isEmpty()){
            return "No movies found";
        }
        return temp;
    }


    public void saveList(MovieCollection m){
        try {
            PrintStream output = new PrintStream(new File("MovieList.csv"));
            for(Movie movie : m.getMovieCollection()){
            output.println(movie.toCSV());}
            System.out.println("The list was succesfully saved!");

        }catch(FileNotFoundException e){
                System.out.println("The program encountered a problem when trying to save..");
            }

    }

    public MovieCollection getMovieCollection() {
        return movieCollection;
    }

    public void loadList(){
        Scanner sc = null;
        File file = new File("MovieList.csv");
        try{
            sc = new Scanner(file, StandardCharsets.ISO_8859_1);

        }catch(FileNotFoundException fnfe){
            System.out.println("could not locate file.");
            throw new RuntimeException(fnfe);

        } catch (IOException e) {
            System.out.println("the program had problems reading the file.");
            throw new RuntimeException(e);
        }
        Movie movieTemp = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(";");
            movieTemp = new Movie(
                    (attributes[0]), // titel
                    (attributes[1]), // director
                    (Integer.parseInt(attributes[2])), // year created
                    (attributes[3]), // inColor
                    (Integer.parseInt(attributes[4])), // lenght
                    (attributes[5]) // genre
            );
            movieCollection.getMovieCollection().add(movieTemp);


        }
        sc.close();

    }



    // ------------------------ START: get og setter ------------------------
    public String getMovieTitel(){
        return movieCollection.getCurrentMovieTitle();
    }
    public void setMovieTitel(String titel){
        movieCollection.setCurrentMovieTitle(titel);
    }

    public String getMovieDirector(){
        return movieCollection.getCurrentMovieDirector();
    }
    public void setMovieDirector(String director){
        movieCollection.setCurrentMovieDirector(director);
    }

    public String getMovieColor(){
        return movieCollection.getCurrentMovieColor();
    }
    public void setMovieColor(String color){
        movieCollection.setCurrentMovieColor(color);
    }

    public String getMovieGenre(){
        return movieCollection.getCurrentMovieGenre();
    }
    public void setMovieGenre(String color){
        movieCollection.setCurrentMovieGenre(color);
    }

    public int getMovieRelease(){
        return movieCollection.getCurrentMovieRelease();
    }
    public void setMovieRelease(int year){
        movieCollection.setCurrentMovieRelease(year);
    }

    public int getMovieLength(){
        return movieCollection.getCurrentMovieLength();
    }
    public void setMovieLength(int length){
        movieCollection.setCurrentMovieLength(length);
    }

    public String getCurrentMovie(){
        return movieCollection.getCurrentMovie();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
