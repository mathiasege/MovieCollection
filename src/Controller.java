import java.util.ArrayList;

public class Controller {
    private final MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    // Opbygger min string med movies.
    public String displayMovie() {
        String display = "";

        // gennemgår liste og tilføjer
        for (Movie movie : movieCollection.getMovies()) {
            display += "\n" + movie.toString();
        }

        // If display.isEmpty(){
        // return "No movies exist"
        //} else{
        // return display
        //}
        return display.isEmpty()
                ? "No movies exist."
                : display;
    }

    // Tilføjer
    public String addMovie(String title, String director, int yearCreated, String isInColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);

        // Returner tilføjet.
        return movieCollection.getCurrentMovie();
    }

    public String deleteMovie(String movieName) {
        // Finder film.
        String movieCheck = checkSpecificMovie(movieName);
        if(!movieCheck.isEmpty()){
            return movieCheck;
        }

        // Fjern.
        movieCollection.deleteMovie();
        return "You removed:\n" + movieCollection.getCurrentMovie();

    }

    // Checker om en film eksistere.
    public String checkSpecificMovie(String movie) {
        try {
            movieCollection.findSpecificMovie(movie);
        } catch (NullPointerException npe) {
            return "The movie doesn't exist";
        }
        return "";
    }

    //search for a film by title:
    public String searchByTitle(String searchTerm){
        String temp = "";
        for(Movie movie : movieCollection.getMovies()){
            if(movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())){
                temp += movie.toString();
            }
        }
        if(temp.isEmpty()){
            return "No movies found";
        }
        return temp;
    }


    // ------------------------ START: get og setter ------------------------
    public String getMovieTitel(){
        return movieCollection.getCurrentMovieTitle();
    }
    public void setMovieTitel(String titel){
        movieCollection.setCurrentMovieTitle(titel);
    }

    public String getMovieDirector(){
        return movieCollection.getCurrentMovieDirector();
    }
    public void setMovieDirector(String director){
        movieCollection.setCurrentMovieDirector(director);
    }

    public String getMovieColor(){
        return movieCollection.getCurrentMovieColor();
    }
    public void setMovieColor(String color){
        movieCollection.setCurrentMovieColor(color);
    }

    public String getMovieGenre(){
        return movieCollection.getCurrentMovieGenre();
    }
    public void setMovieGenre(String color){
        movieCollection.setCurrentMovieGenre(color);
    }

    public int getMovieRelease(){
        return movieCollection.getCurrentMovieRelease();
    }
    public void setMovieRelease(int year){
        movieCollection.setCurrentMovieRelease(year);
    }

    public int getMovieLength(){
        return movieCollection.getCurrentMovieLength();
    }
    public void setMovieLength(int length){
        movieCollection.setCurrentMovieLength(length);
    }

    public String getCurrentMovie(){
        return movieCollection.getCurrentMovie();
    }

    public ArrayList<Movie> getMovies(){
        return movieCollection.getMovies();
    }

    // ------------------------ SLUT: get og setter ------------------------
}
