public class Controller {
    private final MovieCollection movieCollection;

    public Controller(){
        movieCollection = new MovieCollection();
    }

    public String displayMovie(){
        String display = "";

        for(Movie movie : movieCollection.getMovies()){
            display += movie.toString();
        }

        return display;
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre){
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    public void deleteMovie(String movieName){
        movieCollection.deleteMovie(movieCollection.findSpecificMovie(movieName));
    }

    public void editMovie(){

    }
}
