package DomainModel;

import dataSource.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Controller {
    private final MovieCollection movieCollection;
    private final FileHandler fileHandler = new FileHandler();


    public Controller() {
        movieCollection = new MovieCollection();
    }

    // Opbygger min string med movies.
    public String displayMovie(boolean flag, String primaryCriterion, String secondaryCriterion) {
        String display = "";

        if (flag) {
            movieCollection.sortBy(primaryCriterion, secondaryCriterion);
        } else {
            movieCollection.sort();
        }

        for (Movie movie : movieCollection.getMovies()) {
            display += "\n" + movie.toString();
        }

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


    public String searchMovie(String searchWord) {
        boolean movieMatch = false;
        for (Movie m : movieCollection.getMovies()) {
            if (m.getTitle().toLowerCase().contains(searchWord.toLowerCase())) {
                movieMatch = true;
                System.out.println(m + "\n");
            }

        }
        return movieMatch ? "" : "No match found";
    }

    public String deleteMovie(String movieName) {
        // Finder film.
        String movieCheck = checkSpecificMovie(movieName);
        if (!movieCheck.isEmpty()) {
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


    public void saveList(MovieCollection m) {
        fileHandler.saveList(m);

    }

    public MovieCollection getMovieCollection() {
        return movieCollection;
    }


    public void loadList() {
        fileHandler.loadList(movieCollection);
    }


    // ------------------------ START: get og setter ------------------------

    public void setchanged(boolean b) {
        movieCollection.setChanged(b);
    }

    public String getMovieTitel() {
        return movieCollection.getCurrentMovieTitle();
    }

    public void setMovieTitel(String titel) {
        movieCollection.setCurrentMovieTitle(titel);
    }

    public String getMovieDirector() {
        return movieCollection.getCurrentMovieDirector();
    }

    public void setMovieDirector(String director) {
        movieCollection.setCurrentMovieDirector(director);
    }

    public String getMovieColor() {
        return movieCollection.getCurrentMovieColor();
    }

    public void setMovieColor(String color) {
        movieCollection.setCurrentMovieColor(color);
    }

    public String getMovieGenre() {
        return movieCollection.getCurrentMovieGenre();
    }

    public void setMovieGenre(String color) {
        movieCollection.setCurrentMovieGenre(color);
    }

    public int getMovieRelease() {
        return movieCollection.getCurrentMovieRelease();
    }

    public void setMovieRelease(int year) {
        movieCollection.setCurrentMovieRelease(year);
    }

    public int getMovieLength() {
        return movieCollection.getCurrentMovieLength();
    }

    public void setMovieLength(int length) {
        movieCollection.setCurrentMovieLength(length);
    }

    public String getCurrentMovie() {
        return movieCollection.getCurrentMovie();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
