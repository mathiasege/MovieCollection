package models;

import data_source.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MovieCollection {
    // Den sidste specifikke film, som er blevet søgt på.
    private Movie currentMovie;
    // Bruges når man skal update eller delete.
    private ArrayList<Movie> movies;
    private final FileHandler fileHandler;

    // Throws fejl helt til Main.
    public MovieCollection() throws FileNotFoundException {
        movies = new ArrayList<>();
        fileHandler = new FileHandler();

        // Tilføjer fra .txt til liste.
        getMoviesFromTxt();
    }

    // Tilføjer en film.
    public void addMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre)
            throws IOException {
        // Tilføjer til liste og objekt af film.
        currentMovie = new Movie(title, director, yearCreated, color, lengthInMinutes, genre);
        movies.add(currentMovie);

        fileHandler.appendToFile(currentMovie);
    }

    public Movie updateMovie(String oldTitle, String title, String director, int yearCreated, String color, int lengthInMinutes, String genre)
            throws IOException {
        // Finder film
        for (Movie movie : movies) {
            // Hvis den eksistere, ændre data.
            if (movie.getTitle().equals(oldTitle)) {
                movie.setTitle(title);
                movie.setDirector(director);
                movie.setYearCreated(yearCreated);
                movie.setColorFromString(color);
                movie.setLengthInMinutes(lengthInMinutes);
                movie.setGenre(genre);

                // Sætter currentMovie til den man vil opdatere.
                currentMovie = movie;
                break;
            }
        }

        // opdater .txt.
        fileHandler.writeToFile(movies);

        return currentMovie;
    }

    // Sletter en film.
    public boolean deleteMovie(String title) throws IOException {
        Movie tempMovie = null;

        // Finder film, som skal slettes.
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                tempMovie = movie;
            }
        }

        // Fjerner den.
        if (movies.remove(tempMovie)) {
            fileHandler.writeToFile(movies);
            return true;
        } else {
            return false;
        }
    }

    // Finder specifikke film.
    public Movie findSpecificMovie(String movieName) {
        // looper på listen
        for (Movie temp : movies) {
            // Tilføjer hvis den specifikke eksistere.
            if (temp.getTitle().toLowerCase().equals(movieName)) {
                currentMovie = temp;
                return currentMovie;
            }
        }
        return null;
    }

    // Henter alle film fra .txt
    public ArrayList<Movie> getMoviesFromTxt() throws FileNotFoundException {
        movies = fileHandler.getMoviesCollection();
        return movies;
    }

    // !!! KUN TIL TEST FORMÅL !!!
    //search for a movie by its title and return an array list of found movies from the collection:
    //TODO: MAKE THIS NON CASE SENSITIVE
    public ArrayList<Movie> searchByTitle(String title) {
        ArrayList<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())) {
                searchResults.add(movie);
            }
        }

        return searchResults;
    }


    // ------------------------ START: get og setter ------------------------


    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public String getCurrentMovieTitle() {
        return currentMovie.getTitle();
    }

    public String getCurrentMovieDirector() {
        return currentMovie.getDirector();
    }

    public String getCurrentMovieColor() {
        return currentMovie.getColorBoolAsString();
    }

    public String getCurrentMovieGenre() {
        return currentMovie.getGenre();
    }

    public int getCurrentMovieRelease() {
        return currentMovie.getYearCreated();
    }

    public int getCurrentMovieLength() {
        return currentMovie.getLengthInMinutes();
    }

    public String getCurrentMovie() {
        return currentMovie.toString();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
