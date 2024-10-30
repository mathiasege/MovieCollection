import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addOneMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Batman", "Matt Reeves", 2022, "true",190,"action");

        //Act
        int actualSize = movieCollection.getMovies().size();

        //Assert
        int expectedSize = 1;
        assertEquals(actualSize, expectedSize);
    }


    @Test
    void addThreeMovies() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Batman", "Matt Reeves", 2022, "true",190,"action");
        movieCollection.addMovie("Batman Begins", "Christopher Nolan", 2005, "true", 190, "action");
        movieCollection.addMovie("Dark Knight", "Christopher Nolan", 2007, "true", 190, "action");
        //Act
        int actualSize = movieCollection.getMovies().size();

        //Assert
        int expectedSize = 3;
        assertEquals(actualSize, expectedSize);
    }

    @Test
    void emptyList() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();

        //Act
        int actualSize = movieCollection.getMovies().size();

        //Assert
        int expectedSize = 0;
        assertEquals(actualSize, expectedSize);
    }

    @Test
    void searchOneMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Batman", "Matt Reeves", 2022, "true",190,"action");

        //Act
        String actualResult = movieCollection.findSpecificMovie("batman").getTitle();

        //Assert
        String expectedResult = "Batman";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void searchThreeMovies() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Batman", "Matt Reeves", 2022, "true",190,"action");
        movieCollection.addMovie("Batman Begins", "Christopher Nolan", 2005, "true", 190, "action");
        movieCollection.addMovie("Batman Batman", "Christopher Nolan", 2007, "true", 190, "action");
        ArrayList<Movie> actualSize = new ArrayList<>();
        //Act
        for(Movie movie : movieCollection.getMovies()) {
            if(movie.getTitle().toLowerCase().contains("bat")) {
                actualSize.add(movie);
            }
        }
        //Assert
        int expectedSize = 3;

        assertEquals(expectedSize, actualSize.size());
    }

    @Test
    void noMovieFound() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Batman", "Matt Reeves", 2022, "true",190,"action");
        movieCollection.addMovie("Batman Begins", "Christopher Nolan", 2005, "true", 190, "action");
        movieCollection.addMovie("Batman Batman", "Christopher Nolan", 2007, "true", 190, "action");
        ArrayList<Movie> actualSize = new ArrayList<>();
        //Act
        for(Movie movie : movieCollection.getMovies()) {
            if(movie.getTitle().toLowerCase().contains("cat")) {
                actualSize.add(movie);
            }
        }
        //Assert
        int expectedSize = 0;

        assertEquals(expectedSize, actualSize.size());
    }

}