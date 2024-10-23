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
        setIsInColorFromString(color);
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
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

    public void setIsInColorFromString(String color) {
        isInColor = color.equals("YES");
    }
    public String getColorBoolAsString() {
        return isInColor
                ? "Yes"
                : "No";
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
                "length: " + lengthInMinutes + "\n" +
                "genre: " + genre;

    }

}
