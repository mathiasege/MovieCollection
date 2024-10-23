public class Controller {
    private final MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public String displayMovie() {
        String display = "";

        for (Movie movie : movieCollection.getMovies()) {

            display += movie.toString();
        }

        return display;
    }

    public String addMovie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        Movie movie = movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);

        return movie.toString();
    }

    public String deleteMovie(String movieName) {
        Movie movie = movieCollection.findSpecificMovie(movieName);

        if (movie == null) {
            return "The movie doesn't exist.";
        }

        // Fjern
        movieCollection.deleteMovie(movie);
        return "You removed:\n" + movie;

    }

    public Movie findSpecificMovie(String movie) {
        return movieCollection.findSpecificMovie(movie);
    }

    public void updateMovie(Movie oldMovie, Movie newMovie) {
        movieCollection.updateMovie(oldMovie, newMovie);
    }
}
