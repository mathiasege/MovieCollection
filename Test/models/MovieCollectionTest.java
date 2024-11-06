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
    void setup(){
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
            ArrayList<Movie> collection = movieCollection.getMoviesSorted();
            int expectedSize = 3;
            assertEquals(expectedSize, collection.size());
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

    //------------------------------------------------------------------------------------
    // Metoder som skal rykkes væk.

    @Test
    void searchByTitleNoResults() {
        //Arrange:
        testData();
        //Act:
        ArrayList<Movie> searchResults = movieCollection.searchByTitle("Batman");
        int actualResult = searchResults.size();
        //ASSERT:
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult, "Tester om jeg ingen resultater får");
    }

    @Test
    void searchByTitleOneResults() {
        //Arrange:
        testData();
        //Act:
        ArrayList<Movie> searchResults = movieCollection.searchByTitle("P");
        int actualResult = searchResults.size();
        //ASSERT:
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void searchByTitleManyResults() {
        //Arrange:
        testData();
        //Act:
        ArrayList<Movie> searchResults = movieCollection.searchByTitle("Harry Potter");
        int actualResult = searchResults.size();
        //ASSERT:
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }
    //------------------------------------------------------------------------------------

    public void deleteFileContent(){
        try (FileWriter writer = new FileWriter("Movies.txt", false)){
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