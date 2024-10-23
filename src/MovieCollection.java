import java.util.ArrayList;

public class MovieCollection {
    private final ArrayList<Movie> movieCollection = new ArrayList<Movie>();

    public ArrayList<Movie> getMovies(){
        return movieCollection;
    }

    public void addMovie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre){
        Movie movie = new Movie(title, director, yearCreated, color, lengthInMinutes, genre);
        movieCollection.add(movie);
    }

    public Movie findSpecificMovie(String movieName){
        Movie movie = null;

        for(Movie temp : movieCollection){
            if(temp.getTitle().toLowerCase().equals(movieName)){
                movie = temp;
                return movie;
            }
        }

        return null;
    }

    public void deleteMovie(Movie movie){
        movieCollection.remove(movie);
    }

    public void updateMovie(Movie oldMovie, Movie newMovie){
        for(Movie movie : movieCollection){
            if(movie.equals(oldMovie)){
                movie = newMovie;
            }
        }
    }

}