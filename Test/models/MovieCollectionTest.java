package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {
    private MovieCollection movieCollection;

    @BeforeEach
    void setup() {
        deleteFileContent();
        movieCollection = new MovieCollection();
    }

    @Test
    void addOneMovie() {
        try {
            //Arrange:

            //Act:
            movieCollection.addMovie("Harry Potter and the Mystical Object",
                    "H.C Carter",
                    2006,
                    "Yes",
                    120,
                    "Fantasy");

            //Assert:
            ArrayList<Movie> actualSize = movieCollection.getMoviesSorted();
            int expectedSize = 1;
            assertEquals(expectedSize, actualSize.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addThreeMovies() {
        try {
            //Arrange:

            //Act:
            for (int i = 0; i < 3; i++) {
                movieCollection.addMovie("Harry Potter and the Mystical Object",
                        "H.C Carter",
                        2006,
                        "Yes",
                        120,
                        "Fantasy");
            }

            //Assert:
            ArrayList<Movie> actualSize = movieCollection.getMoviesSorted();
            int expectedSize = 3;
            assertEquals(expectedSize, actualSize.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testEmptyCollection() {
        try {
            //Arrange:

            //Act:
            //NOTHING LOL
            //Assert:
            assertTrue(movieCollection.getMoviesSorted().isEmpty(), "Tester om den er tom");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateMovieTitle() {
        // Arrange

        // Act
        try {
            movieCollection.addMovie("Harry Potter and the Mystical Object",
                    "H.C Carter",
                    2006,
                    "Yes",
                    120,
                    "Fantasy");

            String oldTitle = movieCollection.getCurrentMovieTitle();

            movieCollection.updateMovie(oldTitle, "Harry Potter and the Philosophers Stone", "H.C Carter", 2006,
                    "Yes",
                    120,
                    "Fantasy");

            String actualTitle = movieCollection.getCurrentMovieTitle();

            String expectedTitle = "Harry Potter and the Philosophers Stone";

            //Assert:
            assertEquals(expectedTitle, actualTitle);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateMovieYearCreated() {
        // Arrange

        // Act
        try {
            movieCollection.addMovie("Harry Potter and the Mystical Object",
                    "H.C Carter",
                    2006,
                    "Yes",
                    120,
                    "Fantasy");

            String oldTitle = movieCollection.getCurrentMovieTitle();

            movieCollection.updateMovie(oldTitle, "Harry Potter and the Mystical Object",
                    "H.C Carter",
                    2005,
                    "Yes",
                    120,
                    "Fantasy");

            int actualYearCreated = movieCollection.getCurrentMovieRelease();
            int expectedYearCreated = 2005;

            //Assert:
            assertEquals(expectedYearCreated, actualYearCreated);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteMovie() {
        try {
            //Arrange

            movieCollection.addMovie("Harry Potter and the Mystical Object",
                    "H.C Carter",
                    2006,
                    "Yes",
                    120,
                    "Fantasy");
            //Act
            boolean deletedMovie = movieCollection.deleteMovie("Harry Potter and the Mystical Object");

            //Assert
            assertTrue(deletedMovie);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void findSpecificMovie(){
        // Arrange

        //testData();
        Movie expectedMovie = new Movie("Harry Potter and the Goblet of Fire",
                "Benjamin Sierota",
                2004,
                "Yes",
                120,
                "Fantasy");

        movieCollection.addMovie(expectedMovie);

        // Act
        Movie actualMovie = movieCollection.findSpecificMovie("Harry Potter and the Goblet of Fire");
        // Assert
        assertEquals(expectedMovie,actualMovie);
    }

    //------------------------------------------------------------------------------------

    public void deleteFileContent() {
        try (FileWriter writer = new FileWriter("Movies.txt", false)) {
            writer.write("title,director,yearCreated,isInColor,lengthInMinutes,genre");
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void testData() {
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