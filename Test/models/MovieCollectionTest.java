package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest extends DataHandler {
    private MovieCollection movieCollection;

    @BeforeEach
    void setup() {
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
        super.testData();
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

}