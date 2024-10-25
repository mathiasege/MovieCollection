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
            display += movie.toString();
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


    public String searchMovie(String searchWord){
        boolean movieMatch = false;
        for(Movie m : movieCollection.getMovies()){
            if(m.getTitle().toLowerCase().contains(searchWord.toLowerCase())){
                movieMatch = true;
                System.out.println(m + "\n");
            }

        }
        return  movieMatch ? "" : "No match found";
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
        if(movieCollection.findSpecificMovie(movie) == null){
            return "The movie doesn't exist";
        }
        return "";
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

    // ------------------------ SLUT: get og setter ------------------------
}
