import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addOneMovie() {
        //Arrange:
        MovieCollection movieCollection = new MovieCollection();
        //Act:
        movieCollection.addMovie("Harry Potter and the Mystical Object", "H.C Carter", 2006, "Yes", 120, "Fantasy");
        //Assert:
        ArrayList<Movie> collection = movieCollection.getMovieCollection();
        int expectedSize = 1;
        assertEquals(expectedSize, collection.size());
    }

    @Test
    void addThreeMovies(){
        //Arrange:
        MovieCollection movieCollection = new MovieCollection();
        //Act:
        for(int i = 0; i < 3; i++){
            movieCollection.addMovie("Harry Potter and the Mystical Object", "H.C Carter", 2006, "Yes", 120, "Fantasy");
        }

        //Assert:
        ArrayList<Movie> collection = movieCollection.getMovieCollection();
        int expectedSize = 3;
        assertEquals(expectedSize, collection.size());
    }

    @Test
    void addNoMovies(){
        //Arrange:
        MovieCollection movieCollection = new MovieCollection();
        //Act:
        //NOTHING LOL
        //Assert:
        ArrayList<Movie> collection = movieCollection.getMovieCollection();
        int expectedSize = 0;
        assertEquals(expectedSize, collection.size());
    }

    @Test
    void displayAllMovies() {
    }

    @Test
    void searchByTitleNoResults() {
        //Arrange:
        MovieCollection movieCollection = setupSampleMovieCollection();
        //Act:
        ArrayList<Movie> searchResults = movieCollection.searchByTitle("Batman");
        int actualResult = searchResults.size();
        //ASSERT:
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void searchByTitleOneResults() {
        //Arrange:
        MovieCollection movieCollection = setupSampleMovieCollection();
        //Act:
        ArrayList<Movie> searchResults = movieCollection.searchByTitle("Pheonix");
        int actualResult = searchResults.size();
        //ASSERT:
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void searchByTitleManyResults() {
        //Arrange:
        MovieCollection movieCollection = setupSampleMovieCollection();
        //Act:
        ArrayList<Movie> searchResults = movieCollection.searchByTitle("Harry Potter");
        int actualResult = searchResults.size();
        //ASSERT:
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);

    }

    MovieCollection setupSampleMovieCollection(){
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Harry Potter and the Philosophers Stone", "Benjamin Sierota", 2001, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Chamber of Secrets", "Benjamin Sierota", 2002, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Prisoner of Azkaban", "Benjamin Sierota", 2003, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Goblet of Fire", "Benjamin Sierota", 2004, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Order of the Pheonix", "Benjamin Sierota", 2005, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Half-Blood Prince", "Benjamin Sierota", 2006, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Deathly Hallows Part 1", "Benjamin Sierota", 2007, "Yes", 120, "Fantasy");
        movieCollection.addMovie("Harry Potter and the Deathly Hallows Part 2", "Benjamin Sierota", 2008, "Yes", 120, "Fantasy");

        return movieCollection;

    }
}