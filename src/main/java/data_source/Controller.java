package data_source;

import models.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private final MovieCollection movieCollection;

    public Controller() throws FileNotFoundException {
        movieCollection = new MovieCollection();
    }

    // Opbygger string med movies.
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

        try {
            movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        } catch (IOException e) {
            return e.getMessage();
        }
        // Returner tilføjet.
        return movieCollection.getCurrentMovie();
    }

    public String deleteMovie(String title) {
        // Finder film.
        String movieCheck = findSpecificMovie(title);
        if (!movieCheck.isEmpty()) {
            return movieCheck;
        }

        try {
            // Hvis den ikke kan fjerne.
            if(!movieCollection.deleteMovie(title)){
                return "Something went wrong";
            }
        } catch (IOException e) {
            return e.getMessage();
        }

        return "You removed:\n" + movieCollection.getCurrentMovie();
    }

    public String updateMovie(String oldTitle, String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        String checkMovie = findSpecificMovie(oldTitle);
        if (!checkMovie.isEmpty()) {
            return checkMovie;
        }

        try {
            return movieCollection.updateMovie(oldTitle, title, director, yearCreated, isInColor, lengthInMinutes, genre)
                    .toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    // Checker om en film eksistere.
    public String findSpecificMovie(String movie) {
        if (movieCollection.findSpecificMovie(movie) == null) {
            return "The movie doesn't exist";
        }

        return "";
    }

    //search for a film by title:
    public String searchByTitle(String searchTerm) {
        String temp = "";

        for (Movie movie : movieCollection.getMovies()) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                temp += movie.toString();
            }
        }

        if (temp.isEmpty()) {
            return "No movies found";
        }
        return temp;
    }


    // ------------------------ START: get og setter ------------------------


    public ArrayList<Movie> getMovies() {
        return movieCollection.getMovies();
    }

    public String getMovieTitel() {
        return movieCollection.getCurrentMovieTitle();
    }

    public String getMovieDirector() {
        return movieCollection.getCurrentMovieDirector();
    }

    public String getMovieColor() {
        return movieCollection.getCurrentMovieColor();
    }

    public String getMovieGenre() {
        return movieCollection.getCurrentMovieGenre();
    }

    public int getMovieRelease() {
        return movieCollection.getCurrentMovieRelease();
    }

    public int getMovieLength() {
        return movieCollection.getCurrentMovieLength();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
