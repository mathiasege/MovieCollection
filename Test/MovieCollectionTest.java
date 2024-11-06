import models.MovieCollection;
import models.Movie;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addOneMovie() {
        try {
            //Arrange:
            MovieCollection movieCollection = new MovieCollection();
            //Act:
            movieCollection.addMovie("Harry Potter and the Mystical Object", "H.C Carter", 2006, "Yes", 120, "Fantasy");
            //Assert:
            ArrayList<Movie> collection = movieCollection.getMoviesSorted();
            int expectedSize = 1;
            assertEquals(expectedSize, collection.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addThreeMovies() {
        try {
            //Arrange:
            MovieCollection movieCollection = new MovieCollection();
            //Act:
            for (int i = 0; i < 3; i++) {
                movieCollection.addMovie("Harry Potter and the Mystical Object", "H.C Carter", 2006, "Yes", 120, "Fantasy");
            }

            //Assert:
            ArrayList<Movie> collection = movieCollection.getMoviesFromTxt();
            int expectedSize = 3;
            assertEquals(expectedSize, collection.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addNoMovies() {
        try {
            //Arrange:
            MovieCollection movieCollection = new MovieCollection();
            //Act:
            //NOTHING LOL
            //Assert:
            ArrayList<Movie> collection = movieCollection.getMoviesFromTxt();
            int expectedSize = 0;
            assertEquals(expectedSize, collection.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void displayAllMovies() {
    }

    @Test
    void searchByTitleNoResults() {
        try {
            //Arrange:
            MovieCollection movieCollection = new MovieCollection();
            setupSampleMovieCollection();
            //Act:
            ArrayList<Movie> searchResults = movieCollection.searchByTitle("Batman");
            int actualResult = searchResults.size();
            //ASSERT:
            int expectedResult = 0;
            assertEquals(expectedResult, actualResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void searchByTitleOneResults() {
        try {
            //Arrange:
            MovieCollection movieCollection = setupSampleMovieCollection();
            //Act:
            ArrayList<Movie> searchResults = movieCollection.searchByTitle("Pheonix");
            int actualResult = searchResults.size();
            //ASSERT:
            int expectedResult = 8;
            assertEquals(expectedResult, actualResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void searchByTitleManyResults() {
        try {
            //Arrange:
            MovieCollection movieCollection = setupSampleMovieCollection();
            //Act:
            ArrayList<Movie> searchResults = movieCollection.searchByTitle("Harry Potter");
            int actualResult = searchResults.size();
            //ASSERT:
            int expectedResult = 8;
            assertEquals(expectedResult, actualResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    MovieCollection setupSampleMovieCollection() throws IOException {
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
            throw new IOException(e);
        }

        return movieCollection;
    }
}