public class Controller {
    private MovieCollection movieCollection;

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
        movieCollection.deleteMovie(movieCollection.findMovie(movieName));
    }

    public void editMovie(){

    }
}
