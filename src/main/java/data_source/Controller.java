package data_source;

import models.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {
    private final MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    // Opbygger string med movies.
    public String displayMovie() {
        String display = "";

        try {
            // gennemgår liste og tilføjer
            for (Movie movie : movieCollection.getMoviesFromTxt()) {
                display += "\n" + movie.toString();
            }
        } catch (FileNotFoundException e) {
            return e.getMessage();
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

    public String deleteMovie(String movieName) {
        // Finder film.
        String movieCheck = findSpecificMovie(movieName);
        if (!movieCheck.isEmpty()) {
            return movieCheck;
        }

        // Fjern.
//        movieCollection.deleteMovie();
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
        } catch (IOException e){
            return e.getMessage();
        }
    }

    // Checker om en film eksistere.
    public String findSpecificMovie(String movie) {
        try {
            // !!! Ved ikke om det bliver for besværligt at læse sådan her !!!
            if (movieCollection.findSpecificMovie(movie, movieCollection.getMoviesFromTxt()) == null) {
                return "The movie doesn't exist";
            }
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }

        return "";
    }

    //search for a film by title:
    public String searchByTitle(String searchTerm) {
        String temp = "";

        try {
            for (Movie movie : movieCollection.getMoviesFromTxt()) {
                if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                    temp += movie.toString();
                }
            }
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }


        if (temp.isEmpty()) {
            return "No movies found";
        }
        return temp;
    }


    // ------------------------ START: get og setter ------------------------
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

//    public ArrayList<Movie> getMovies() {
//        return movieCollection.getMovies();
//    }

    // ------------------------ SLUT: get og setter ------------------------
}
