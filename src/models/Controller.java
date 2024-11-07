package models;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    private final MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }


    // Opbygger string med movies.
    public String displayMovie() {
        StringBuilder display = new StringBuilder();

        // gennemgår liste og tilføjer
        for (Movie movie : movieCollection.getMoviesSorted()) {
            display.append("\n").append(movie.toString());
        }

        return (display.isEmpty())
                ? "No movies exist."
                : display.toString();
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
            if (!movieCollection.deleteMovie(title)) {
                return "Something went wrong";
            }
        } catch (IOException e) {
            return e.getMessage();
        }

        return "You removed:\n" + movieCollection.getCurrentMovie();
    }

    public String updateMovie(String oldTitle, String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        // Tjekker om filmen eksistere.
        String checkMovie = findSpecificMovie(oldTitle);
        if (!checkMovie.isEmpty()) {
            return checkMovie;
        }

        // Opdatere
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
        // Laver en stringbuilder
        StringBuilder temp = new StringBuilder();

        // tilføjer til stringbuilder
        for (Movie movie : movieCollection.getMoviesSorted()) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                temp.append(movie);
            }
        }

        // hvis ingen er fundet
        if (temp.isEmpty()) {
            return "No movies found";
        }

        return temp.toString();
    }

    public String userChoiceSort(String[] picked) {
        // Sætter array og tjekker for null.
        ArrayList<Movie> sorted = movieCollection.userChoiceSort(picked);
        if(sorted == null){
            return "You typed something wrong";
        }

        // laver en stringbuilder.
        StringBuilder result = new StringBuilder();

        for (Movie movie : sorted) {
            // Tilføjer til udprint
            result.append("\n").append(movie);
        }

        return result.toString();
    }

        // ------------------------ START: get og setter ------------------------


        public ArrayList<Movie> getMoviesSorted () {
            return movieCollection.getMoviesSorted();
        }

        public String getMovieTitel () {
            return movieCollection.getCurrentMovieTitle();
        }

        public String getMovieDirector () {
            return movieCollection.getCurrentMovieDirector();
        }

        public String getMovieColor () {
            return movieCollection.getCurrentMovieColor();
        }

        public String getMovieGenre () {
            return movieCollection.getCurrentMovieGenre();
        }

        public int getMovieRelease () {
            return movieCollection.getCurrentMovieRelease();
        }

        public int getMovieLength () {
            return movieCollection.getCurrentMovieLength();
        }

        // ------------------------ SLUT: get og setter ------------------------
    }
