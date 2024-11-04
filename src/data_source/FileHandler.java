package data_source;

import models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final String filePath;

    public FileHandler() {
        filePath = "Movies.txt";
    }

    public void appendToFile(Movie movie) throws IOException {
        // Opretter FileWriter i append mode. True er for at kunne skrive til den
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(movie.getTitle() + ","
                    + movie.getDirector() + ","
                    + movie.getYearCreated() + ","
                    + movie.getColorBoolAsString() + ","
                    + movie.getLengthInMinutes() + ","
                    + movie.getGenre());
        }
    }

    // Den overskriver den movies.txt.
    public void writeToFile(ArrayList<Movie> movies) throws IOException {
        // over skriver alle filmene i filen med data fra movies listen.
        try (FileWriter writer = new FileWriter(filePath)) { // Overskriver hele filen
            writer.write("title,director,yearCreated,isInColor,lengthInMinutes,genre" + System.lineSeparator());
            for (Movie movie : movies) {
                writer.write(movie.getTitle() + "," +
                        movie.getDirector() + "," +
                        movie.getYearCreated() + "," +
                        movie.getColorBoolAsString() + "," +
                        movie.getLengthInMinutes() + "," +
                        movie.getGenre());
                // ny linje
                writer.write(System.lineSeparator());
            }
        }
    }

    public ArrayList<Movie> getMoviesCollection() throws FileNotFoundException {
        // Opretter en variabel af fil og movie list
        File file = new File(filePath);
        ArrayList<Movie> temp = new ArrayList<>();

        // Åbner forbindelse. Den lukker automatisk.
        try (Scanner sc = new Scanner(new File(String.valueOf(file)))) {
            // Skip første linje. Headeren
            sc.nextLine();

            while (sc.hasNextLine()) {
                // Hvis linjen er tom, spring over.
                String line = sc.nextLine();

                String[] attributes = line.split(",");

                // Opret en ny Movie og tilføj til listen
                Movie movie = new Movie(
                        attributes[0],
                        attributes[1],
                        Integer.parseInt(attributes[2]),
                        attributes[3],
                        Integer.parseInt(attributes[4]),
                        attributes[5]
                );
                temp.add(movie);
            }
        }

        return temp;
    }
}
