package data_source;

import models.Movie;
import models.MovieCollection;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

class FileHandlerTest {
    private MovieCollection movieCollection;
    private Movie movie;

    @Test
    void fileNotFoundFound() {
        String actualResult = "";
        try (Scanner scanner = new Scanner(Paths.get("Bob.txt"))){
            actualResult = "File found.";
        } catch (IOException e) {
            actualResult = "File not found.";
        }
        String expectedResult = "File not found.";
        assert(expectedResult.equals(actualResult));
    }

    @Test
    void fileFound() {
        String actualResult = "";
        try (Scanner scanner = new Scanner(Paths.get("Movies.txt"))){
            actualResult = "File found.";
        } catch (IOException e) {
            actualResult = "File not found.";
        }
        String expectedResult = "File found.";
        assert(expectedResult.equals(actualResult));
    }

    @Test
    void writeToFileAndRead()  {
            // Opretter FileWriter i append mode. True er for at kunne skrive til den
        Movie movie = new Movie("Batman", "Nolan", 2005,"yes",190,"action");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Movies.txt", false));
                writer.write(movie.getTitle() + ","
                        + movie.getDirector() + ","
                        + movie.getYearCreated() + ","
                        + movie.getColorBoolAsString() + ","
                        + movie.getLengthInMinutes() + ","
                        + movie.getGenre());
                // ny linje
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String line = "";
            try {
                Scanner scanner = new Scanner(Paths.get("Movies.txt"));
                line = scanner.nextLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String expectedResult = "Batman,Nolan,2005,No,190,action";
            String actualResult = line;
            assert(expectedResult.equals(actualResult));
    }
}