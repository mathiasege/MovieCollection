package models;

import Extension.DataHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest extends DataHandler {

    @Test
    void testDisplayMovie() {
        // Arrange: Fylder movieCollection med testdata
        super.testData();
        Controller controller = new Controller();

        // Act: Kald displayMovie() for at få resultatstrengen
        String result = controller.displayMovie();

        // Assert: Sammenlign resultatet med det forventede output
        String expectedOutput = """
                
                Name: Harry Potter and the Chamber of Secrets
                Director: Benjamin Sierota
                Created: 2002
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Deathly Hallows Part 1
                Director: Benjamin Sierota
                Created: 2007
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Deathly Hallows Part 2
                Director: Benjamin Sierota
                Created: 2008
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Goblet of Fire
                Director: Benjamin Sierota
                Created: 2004
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Half-Blood Prince
                Director: Benjamin Sierota
                Created: 2006
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Order of the Pheonix
                Director: Benjamin Sierota
                Created: 2005
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Philosophers Stone
                Director: Benjamin Sierota
                Created: 2001
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                
                Name: Harry Potter and the Prisoner of Azkaban
                Director: Benjamin Sierota
                Created: 2003
                Is in color: Yes
                Length: 120
                Genre: Fantasy
                """;


        assertEquals(expectedOutput, result);
    }



}