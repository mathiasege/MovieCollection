package DomainModel;

import java.util.Comparator;

public class Movie implements Comparable<Movie> {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;


    //this is where we control what the Comparator searches with.
    public static final Comparator<Movie> TITLE_COMPARATOR = Comparator.comparing(Movie::getTitle);
    public static final Comparator<Movie> DIRECTOR_COMPARATOR = Comparator.comparing(Movie::getDirector);
    public static final Comparator<Movie> YEAR_COMPARATOR = Comparator.comparingInt(Movie::getYearCreated);
    public static final Comparator<Movie> LENGHT_COMPARATOR = Comparator.comparingInt(Movie::getLengthInMinutes);
    public static final Comparator<Movie> COLOR_COMPARATOR = Comparator.comparing(Movie::getColorBoolAsString);



    public static final Comparator<Movie> TITLE_THEN_DIRECTOR_COMPARATOR =
            TITLE_COMPARATOR.thenComparing(DIRECTOR_COMPARATOR);
    public static final Comparator<Movie> TITLE_THEN_YEAR_COMPARATOR =
            TITLE_COMPARATOR.thenComparing(YEAR_COMPARATOR);
    public static final Comparator<Movie> TITLE_THEN_LENGHT_COMPARATOR =
            TITLE_COMPARATOR.thenComparing(LENGHT_COMPARATOR);






    public Movie(String title, String director, int yearCreated, String color, int lengthInMinutes, String genre) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toCSV() {
        return title + ";" + director + ";" + yearCreated + ";" + isInColor + ";" + lengthInMinutes + ";" + genre;
    }

    @Override
    public String toString() {
        return "Name: " + title + "\n" +
                "Director: " + director + "\n" +
                "Created: " + yearCreated + "\n" +
                "Is in color: " + getColorBoolAsString() + "\n" +
                "Length: " + lengthInMinutes + "\n" +
                "Genre: " + genre + "\n";

    }

    @Override
    public int compareTo(Movie o) {
        int result = this.getTitle().compareToIgnoreCase(o.getTitle());
        return result != 0 ? result : this.getDirector().compareTo(o.getDirector()) ;
    }
}
