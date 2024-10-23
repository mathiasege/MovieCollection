public class Movie {
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

    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre(){
        return  genre;
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

}
