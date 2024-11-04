public class Movie implements Comparable<Movie>{
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre){
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated){
        this.yearCreated = yearCreated;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public void setInColor(boolean isInColor){
        this.isInColor = isInColor;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes){
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getGenre(){
        return  genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    @Override
    public String toString(){
        String output = "";
        output  += "Movie: " + title + " \n";
        output  += "Director: " + director + " \n";
        output  += "Year Created: " + yearCreated + " \n";
        output  += "Is in color: ";
        if(isInColor){
            output += "Yes \n";
        }else {
            output += "No \n";
        }
        output += "Length (in minutes) : " + lengthInMinutes + " \n";
        output += "Genre: " + genre;

        return output;
    }


    public int compareTo(Movie other){
        return title.toLowerCase().compareTo(other.getTitle().toLowerCase());
    }

}
