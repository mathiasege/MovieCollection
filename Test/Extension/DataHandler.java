package Extension;

import models.MovieCollection;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileWriter;
import java.io.IOException;

public class DataHandler {

    @BeforeEach
    void dataSetUp() {
        deleteFileContent();
    }

    public void deleteFileContent() {
        try (FileWriter writer = new FileWriter("Movies.txt", false)) {
            writer.write("title,director,yearCreated,isInColor,lengthInMinutes,genre");
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void testData() {
        MovieCollection movieCollection = new MovieCollection();
        try {
            movieCollection.addMovie("Harry Potter and the Philosophers Stone", "Benjamin Sierota", 2001, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Chamber of Secrets", "Benjamin Sierota", 2002, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Prisoner of Azkaban", "Benjamin Sierota", 2003, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Goblet of Fire", "Benjamin Sierota", 2004, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Order of the Pheonix", "Benjamin Sierota", 2005, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Half-Blood Prince", "Benjamin Sierota", 2006, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Deathly Hallows Part 1", "Benjamin Sierota", 2007, "Yes", 120, "Fantasy");
            movieCollection.addMovie("Harry Potter and the Deathly Hallows Part 2", "Benjamin Sierota", 2008, "Yes", 120, "Fantasy");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
