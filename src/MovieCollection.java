import java.util.ArrayList;

public class MovieCollection {
    private final ArrayList<Movie> movieCollection;
    // Den sidste specifikke film, som er blevet søgt på.
    private Movie currentMovie;

    public MovieCollection() {
        movieCollection = new ArrayList<>();

        // Tilføjer en til test
        //Do this outside the movie collection class instead
        Movie batman = new Movie("Batman", "Chris", 2005, "Yes", 180,"Action");
        movieCollection.add(batman);
    }

    // Tilføjer en film.
    public void addMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre) {
        currentMovie = new Movie(title, director, yearCreated, color, lengthInMinutes, genre);
        movieCollection.add(currentMovie);
    }

    // Finder specifikke film.
    public Movie findSpecificMovie(String movieName) {
        // looper på listen
        for (Movie temp : movieCollection) {
            // Tilføjer hvis den specifikke eksistere.
            if (temp.getTitle().toLowerCase().equals(movieName)) {
                currentMovie = temp;
                return currentMovie;
            }
        }
        return null;
    }

    // Sletter en film.
    public void deleteMovie() {
        movieCollection.remove(currentMovie);
    }

    //search for a movie by its title and return an array list of found movies from the collection:
    //TODO: MAKE THIS NON CASE SENSITIVE
    public ArrayList<Movie> searchByTitle(String title) {
        ArrayList<Movie> searchResults = new ArrayList<Movie>();
        for (Movie movie : movieCollection) {
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())) {
                searchResults.add(movie);
            }
        }

        return searchResults;
    }


    // ------------------------ START: get og setter ------------------------
    public ArrayList<Movie> getMovies() {
        return movieCollection;
    }

    public String getCurrentMovieTitle() {
        return currentMovie.getTitle();
    }

    public void setCurrentMovieTitle(String title) {
        currentMovie.setTitle(title);
    }

    public String getCurrentMovieDirector() {
        return currentMovie.getDirector();
    }

    public void setCurrentMovieDirector(String director) {
        currentMovie.setDirector(director);
    }

    public String getCurrentMovieColor() {
        return currentMovie.getColorBoolAsString();
    }

    public void setCurrentMovieColor(String color) {
        currentMovie.setColorFromString(color);
    }

    public String getCurrentMovieGenre() {
        return currentMovie.getGenre();
    }

    public void setCurrentMovieGenre(String genre) {
        currentMovie.setGenre(genre);
    }

    public int getCurrentMovieRelease() {
        return currentMovie.getYearCreated();
    }

    public void setCurrentMovieRelease(int year) {
        currentMovie.setYearCreated(year);
    }

    public int getCurrentMovieLength() {
        return currentMovie.getLengthInMinutes();
    }

    public void setCurrentMovieLength(int length) {
        currentMovie.setLengthInMinutes(length);
    }

    public String getCurrentMovie() {
        try {
            return currentMovie.toString();
        } catch (NullPointerException npl) {
            System.out.println("No such movie found.");
        }
        return "";
    }

    public ArrayList<Movie> getMovieCollection() {
        return movieCollection;
    }

    // ------------------------ SLUT: get og setter ------------------------

@Override
    public String toString(){
    for (Movie movie : movieCollection) {
        System.out.println("\n" + movie.toString());
    }
    return "";
}



}
