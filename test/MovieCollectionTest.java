import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addOneMovie() {
        //Arrange --
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Avengers Endgame", "Russo Brothers", 2019, "Yes", 162, "Action");


        //Act --
        int actualSize = movieCollection.getMovies().size();

        //Assert --
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void addThreeMovies() {
        //Arrange --

        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Lion King", "Disney", 1995, "Yes", 122, "Kids");
        movieCollection.addMovie("Matrix", "Russo Brothers", 1995, "Yes", 132, "Action");
        movieCollection.addMovie("Titanic", "Spielberg", 1995, "Yes", 132, "Romance");
        //Act --
        int actualSize = movieCollection.getMovies().size();

        //Assert --
        int expectedSize = 3;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void searchMoviesEmpty() {
        //Arrange --
        MovieCollection movieCollection = new MovieCollection();

        //Act --
        Movie actualResult = movieCollection.findSpecificMovie("SearchWord");

        //Assert --
        assertNull(actualResult);

    }

    @Test
    void searchMoviesHasOne() {
        //Arrange --
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Lion King", "Disney", 1995, "Yes", 122, "Kids");


        //Act --
        int actualResult = movieCollection.getMovies().size();

        //Assert --
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void searchMoviesHasMany() {
        //Arrange --
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Lion King", "Disney", 1995, "Yes", 122, "Kids");
        movieCollection.addMovie("Lion King", "Disney", 1995, "Yes", 122, "Kids");
        movieCollection.addMovie("Matrix", "Russo Brothers", 1995, "Yes", 132, "Action");
        movieCollection.addMovie("Titanic", "Spielberg", 1995, "Yes", 132, "Romance");


        //Act --
        int actualResult = movieCollection.getMovies().size();

        boolean moreThanOne= false;

        if (actualResult > 1){
            moreThanOne = true;
        }

        //Assert --

        assertTrue(moreThanOne);
    }


}