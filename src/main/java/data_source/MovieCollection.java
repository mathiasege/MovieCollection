package data_source;

import models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private final ArrayList<Movie> movieCollection;
    // Den sidste specifikke film, som er blevet søgt på.
    private Movie currentMovie;

    public MovieCollection() {
        movieCollection = new ArrayList<>();

        /* Tilføjer en til test
        Main.models.Movie batman = new Main.models.Movie("Batman", "Chris", 2005, "Yes", 180,"Action");
        movieCollection.add(batman); */
    }

    // Tilføjer en film.
    public void addMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre) throws IOException {
        currentMovie = new Movie(title, director, yearCreated, color, lengthInMinutes, genre);

        // Opretter FileWriter i append mode. true er for at kunne skrive til den
        try (FileWriter writer = new FileWriter("Movies.txt", true)) {
            // Tilføjer ";". Det er til for, at et menneske kan læse hvornår en record stopper.
            writer.write(title + "," + director + "," + yearCreated + "," + color + "," + lengthInMinutes + "," + genre);
            writer.write(System.lineSeparator());
        }
    }

    // Finder specifikke film.
    public Movie findSpecificMovie(String movieName) {
        // looper på listen
        for (Movie temp : movieCollection) {
            // Tilføjer hvis den specifikke eksistere.
            if (temp.getTitle().toLowerCase().equals(movieName)) {
                currentMovie = temp;
                return currentMovie;
            }
        }
        return null;
    }

    // Sletter en film.
    public void deleteMovie() {
        movieCollection.remove(currentMovie);
    }

    public ArrayList<Movie> getMovies() throws FileNotFoundException {
        File file = new File("Movies.txt");

        try (Scanner sc = new Scanner(new File(String.valueOf(file)))) {
            sc.nextLine();  // Skip første linje (hvis det er en header)

            while (sc.hasNextLine()) {
                String line = sc.nextLine();    // Læs linje
                String[] attributes = line.split(","); // Split linje i attributter

                // Opret en ny Movie og tilføj til listen
                Movie movie = new Movie(
                        attributes[0],                       // Titel
                        attributes[1],                       // Instruktør
                        Integer.parseInt(attributes[2]),     // År
                        attributes[3],                       // Farve
                        Integer.parseInt(attributes[4]),     // Længde i minutter
                        attributes[5].replace(";","")                      // Genre
                );

                movieCollection.add(movie); // Tilføj filmen til samlingen
            }
        }
        return movieCollection;
    }

    // ------------------------ START: get og setter ------------------------

    public String getCurrentMovieTitle() {
        return currentMovie.getTitle();
    }

    public void setCurrentMovieTitle(String title) {
        currentMovie.setTitle(title);
    }

    public String getCurrentMovieDirector() {
        return currentMovie.getDirector();
    }

    public void setCurrentMovieDirector(String director) {
        currentMovie.setDirector(director);
    }

    public String getCurrentMovieColor() {
        return currentMovie.getColorBoolAsString();
    }

    public void setCurrentMovieColor(String color) {
        currentMovie.setColorFromString(color);
    }

    public String getCurrentMovieGenre() {
        return currentMovie.getGenre();
    }

    public void setCurrentMovieGenre(String genre) {
        currentMovie.setGenre(genre);
    }

    public int getCurrentMovieRelease() {
        return currentMovie.getYearCreated();
    }

    public void setCurrentMovieRelease(int year) {
        currentMovie.setYearCreated(year);
    }

    public int getCurrentMovieLength() {
        return currentMovie.getLengthInMinutes();
    }

    public void setCurrentMovieLength(int length) {
        currentMovie.setLengthInMinutes(length);
    }

    public String getCurrentMovie() {
        return currentMovie.toString();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
