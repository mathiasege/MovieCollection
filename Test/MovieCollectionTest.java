import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addManyMovie() {
        // Arrange - lav en instans af den klasse, som du vil teste.
        // Lav test data - hvis nødvendigt.
        MovieCollection movieCollection = new MovieCollection();
        int expectedInt = 3;

        // Act - her executer du den kode, som du vil teste
        movieCollection.addMovie("Tarzan","Mathias Clausen", 1995,"Yes",180,"Action");
        movieCollection.addMovie("Batman","Mathias Clausen", 2000,"no",200,"Action");
        movieCollection.addMovie("Catch me if you can","Mathias Clausen", 2002,"Yes",180,"Action");
        int actualSize = movieCollection.getMovies().size();


        // Assert - Bekræfter, at koden du tester, virker som den skal.
        assertEquals(expectedInt, actualSize);
    }
    @Test
    void addOneMovie() {
        // Arrange - lav en instans af den klasse, som du vil teste.
        // Lav test data - hvis nødvendigt.
        MovieCollection movieCollection = new MovieCollection();
        int expectedInt = 1;

        // Act - her executer du den kode, som du vil teste
        movieCollection.addMovie("Tarzan","Mathias Clausen", 1995,"Yes",180,"Action");
        int actualSize = movieCollection.getMovies().size();


        // Assert - Bekræfter, at koden du tester, virker som den skal.
        assertEquals(expectedInt, actualSize);
    }

    @Test
    void getThreeMovies() {
        MovieCollection movieCollection = new MovieCollection();
        int expectedInt = 3;

        // Act - her executer du den kode, som du vil teste
        movieCollection.addMovie("Tarzan","Mathias Clausen", 1995,"Yes",180,"Action");
        movieCollection.addMovie("Batman","Mathias Clausen", 2000,"no",200,"Action");
        movieCollection.addMovie("Catch me if you can","Mathias Clausen", 2002,"Yes",180,"Action");
        int actualSize = movieCollection.searchByTitle("a").size();

        // Assert - Bekræfter, at koden du tester, virker som den skal.
        assertEquals(expectedInt, actualSize);
    }

    @Test
    void getOneMovies() {
        MovieCollection movieCollection = new MovieCollection();
        int expectedInt = 1;

        // Act - her executer du den kode, som du vil teste
        movieCollection.addMovie("Tarzan","Mathias Clausen", 1995,"Yes",180,"Action");
        movieCollection.addMovie("Batman","Mathias Clausen", 2000,"no",200,"Action");
        movieCollection.addMovie("Catch me if you can","Mathias Clausen", 2002,"Yes",180,"Action");
        int actualSize = movieCollection.searchByTitle("c").size();

        // Assert - Bekræfter, at koden du tester, virker som den skal.
        assertEquals(expectedInt, actualSize);
    }

    @Test
    void getNullMovies() {
        MovieCollection movieCollection = new MovieCollection();
        int expectedInt = 0;

        // Act - her executer du den kode, som du vil teste
        movieCollection.addMovie("Tarzan","Mathias Clausen", 1995,"Yes",180,"Action");
        movieCollection.addMovie("Batman","Mathias Clausen", 2000,"no",200,"Action");
        movieCollection.addMovie("Catch me if you can","Mathias Clausen", 2002,"Yes",180,"Action");
        int actualSize = movieCollection.searchByTitle("æ").size();

        // Assert - Bekræfter, at koden du tester, virker som den skal.
        assertEquals(expectedInt, actualSize);
    }
}