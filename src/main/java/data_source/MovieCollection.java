package data_source;

import models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    // Den sidste specifikke film, som er blevet søgt på.
    private Movie currentMovie;
    // Bruges når man skal update eller delete.
    private ArrayList<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
        /* Tilføjer en til test
        Main.models.Movie batman = new Main.models.Movie("Batman", "Chris", 2005, "Yes", 180,"Action");
        movieCollection.add(batman); */
    }

    // Tilføjer en film.
    public void addMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre) throws IOException {
        currentMovie = new Movie(title, director, yearCreated, color, lengthInMinutes, genre);

        // Opretter FileWriter i append mode. True er for at kunne skrive til den
        try (FileWriter writer = new FileWriter("Movies.txt", true)) {
            // Tilføjer ";". Det er til for, at et menneske kan læse hvornår en record stopper.
            writer.write(title + ","
                    + director + ","
                    + yearCreated + ","
                    + color + ","
                    + lengthInMinutes + ","
                    + genre);
            writer.write(System.lineSeparator());
        }
    }

    public Movie updateMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre) throws IOException {
        // Ændre navnet i listen.
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
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

        // over skriver alle filmene i filen med movies listen.
        try (FileWriter writer = new FileWriter("Movies.txt")) { // Overskriver hele filen
            for (Movie movie : movies) {
                writer.write(movie.getTitle() + "," +
                        movie.getDirector() + "," +
                        movie.getYearCreated() + "," +
                        movie.getColorBoolAsString() + "," +
                        movie.getLengthInMinutes() + "," +
                        movie.getGenre());
                writer.write(System.lineSeparator());
            }
        }

        return currentMovie;
    }

    // Sletter en film.
//    public void deleteMovie() {
//        movieCollection.remove(currentMovie);
//    }

    // Finder specifikke film.
    public Movie findSpecificMovie(String movieName, ArrayList<Movie> movies) {
        this.movies = movies;

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
    public ArrayList<Movie> getMovies() throws FileNotFoundException {
        // Opretter en variabel af fil og movie list
        File file = new File("Movies.txt");
        ArrayList<Movie> movieCollection = new ArrayList<>();

        // Åbner forbindelse. Den lukker automatisk.
        try (Scanner sc = new Scanner(new File(String.valueOf(file)))) {
            sc.nextLine();  // Skip første linje (hvis det er en header)

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] attributes = line.split(",");

                // Opret en ny Movie og tilføj til listen
                Movie movie = new Movie(
                        attributes[0],
                        attributes[1],
                        Integer.parseInt(attributes[2]),
                        attributes[3],
                        Integer.parseInt(attributes[4]),
                        attributes[5].replace(";", "")
                );
                movieCollection.add(movie);
            }
        }

        return movieCollection;
    }

    // ------------------------ START: get og setter ------------------------

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
