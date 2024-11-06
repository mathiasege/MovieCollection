package models;



public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre){
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        // Har lagt et lag oven på boolean isInColor
        setColorFromString(color);
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    // Laver min håndtering for Color.
    // Sætter til sandt eller falsk
    public void setColorFromString(String color) {
        isInColor = color.equals("YES");
    }
    // Henter color.
    public String getColorBoolAsString() {
        // if(isInColor) {
        //  return "Yes"
        //} else{
        // return "No"
        //}
        return isInColor
                ? "Yes"
                : "No";
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearCreated() {
        return yearCreated;
    }
    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }


    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getGenre(){
        return  genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return "Name: " + title + "\n" +
                "Director: " + director + "\n" +
                "Created: " + yearCreated + "\n" +
                "Is in color: " + getColorBoolAsString() + "\n" +
                "Length: " + lengthInMinutes + "\n" +
                "Genre: " + genre + "\n";

    }

}
