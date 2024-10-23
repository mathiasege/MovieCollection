import java.util.ArrayList;

public class MovieCollection {
    private final ArrayList<Movie> movieCollection;
    // Den sidste specifikke film, som er blevet søgt på.
    private Movie currentMovie;

    public MovieCollection(){
        movieCollection = new ArrayList<>();

        // Tilføjer en til test
        Movie batman = new Movie("Batman", "Chris", 2005, "Yes", 180,"Action");
        movieCollection.add(batman);
    }

    // Tilføjer en film.
    public Movie addMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre){
        Movie movie = new Movie(title, director, yearCreated, color, lengthInMinutes, genre);
        movieCollection.add(movie);

        return movie;
    }

    // Finder specifikke film.
    public Movie findSpecificMovie(String movieName){
        // looper på listen
        for(Movie temp : movieCollection){
            // Tilføjer hvis den specifikke eksistere.
            if(temp.getTitle().toLowerCase().equals(movieName)){
                currentMovie = temp;
                return currentMovie;
            }
        }
        return null;
    }

    // Sletter en film.
    public void deleteMovie(Movie movie){
        movieCollection.remove(movie);
    }


    // ------------------------ START: get og setter ------------------------
    public ArrayList<Movie> getMovies(){
        return movieCollection;
    }

    public String getCurrentMovieTitle() {
        return currentMovie.getTitle();
    }
    public void setCurrentMovieTitle(String title){
        currentMovie.setTitle(title);
    }

    public String getCurrentMovieDirector(){
        return currentMovie.getDirector();
    }
    public void setCurrentMovieDirector(String director){
        currentMovie.setDirector(director);
    }

    public String getCurrentMovieColor(){
        return currentMovie.getColorBoolAsString();
    }
    public void setCurrentMovieColor(String color){
        currentMovie.setColorFromString(color);
    }

    public String getCurrentMovieGenre(){
        return currentMovie.getGenre();
    }
    public void setCurrentMovieGenre(String genre){
        currentMovie.setGenre(genre);
    }

    public int getCurrentMovieRelease(){
        return currentMovie.getYearCreated();
    }
    public void setCurrentMovieRelease(int year){
        currentMovie.setYearCreated(year);
    }

    public int getCurrentMovieLength(){
        return currentMovie.getLengthInMinutes();
    }
    public void setCurrentMovieLength(int length){
        currentMovie.setLengthInMinutes(length);
    }

    public String getCurrentMovie() {
        return currentMovie.toString();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
