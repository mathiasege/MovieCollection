import java.util.Scanner;

public class UserInterface {

    private final Controller controller;

    public UserInterface() {
        controller = new Controller();
    }

    public void game() {
        String userChoice = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the movie collection program");

        while (!userChoice.equals("END")) {
            System.out.println("Please enter a command:");
            System.out.println("Display: show movies");
            System.out.println("Add: add a new movie");
            System.out.println("Delete: Delete a movie");
            System.out.println("Update: Update a movie");
            System.out.println("End: exit");

            userChoice = input.nextLine().toUpperCase();

            switch (userChoice) {
                case "DISPLAY" -> displayMovie();
                case "ADD" -> addMovie();
                case "DELETE" -> deleteMovie();
                case "UPDATE" -> updateMovie();
                case "END" -> System.out.println("You're ending the game.");
                default -> System.out.println("Please enter a valid command");
            }
        }
    }

    private void displayMovie() {
        System.out.println(controller.displayMovie());
    }

    private void addMovie() {
        Scanner scan = new Scanner(System.in);

        System.out.println("name of the movie:");
        String movieName = checkString(scan.nextLine().trim(), scan);

        System.out.println("name of the director:");
        String movieDirector = checkString(scan.nextLine().trim(), scan);

        System.out.println("the movie is in color. (Yes or No)");
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan);

        System.out.println("name of the genre.");
        String genre = checkString(scan.nextLine().trim(), scan);

        System.out.println("Length of the movie");
        int length = checkInt(scan.nextInt(), scan);

        System.out.println("Created:");
        int year = checkInt(scan.nextInt(), scan);

        controller.addMovie(movieName,
                movieDirector,
                year,
                color,
                length,
                genre);
    }

    private void deleteMovie() {
        System.out.println("Type the name of the movie you would like to remove");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        controller.deleteMovie(movie);
    }

    private void updateMovie() {
        System.out.println("Type the name of the movie you would like to edit");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        Movie oldMovie = controller.findSpecificMovie(movie);

        Movie newMovie = changeMovie(oldMovie);

        controller.updateMovie(oldMovie, newMovie);
    }

    private Movie changeMovie(Movie movie) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Movie name: " + movie.getTitle());
        System.out.println("New movie name:");
        movie.setTitle(checkString(scan.nextLine().trim(), scan));

        System.out.println("Director name: " + movie.getDirector());
        System.out.println("New director name:");
        movie.setDirector(checkString(scan.nextLine().trim(), scan));

        System.out.println("Movie is in color: " + movie.getColorBoolAsString());
        System.out.println("Is in color, Yes or No:");
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan);
        movie.setIsInColorFromString(color);

        System.out.println("Movie genre: " + movie.getGenre());
        System.out.println("New genre:");
        movie.setGenre(checkString(scan.nextLine().trim(), scan));

        System.out.println("Year created: " + movie.getYearCreated());
        System.out.println("New movie year:");
        movie.setYearCreated(checkInt(scan.nextInt(), scan));

        System.out.println("Movie length: " + movie.getLengthInMinutes());
        System.out.println("New movie length:");
        movie.setLengthInMinutes(checkInt(scan.nextInt(), scan));

        return movie;
    }

    private String checkString(String value, Scanner scan) {
        scan = new Scanner(System.in);

        while (value.isEmpty()) {
            System.out.println("You must type something.");

            value = scan.nextLine();
        }

        return value;
    }

    private int checkInt(int value, Scanner scan) {
        scan = new Scanner(System.in);

        if (value > 0) {
            return value;
        }

        while (!scan.hasNextInt()) {
            System.out.println("That's not a number!");
            scan.next(); // this is important!
        }

        value = scan.nextInt();
        return value;
    }

    public String stringIsYesNo(String color, Scanner scan){
        while(!color.equals("YES") && !color.equals("NO")){
            System.out.println("Try agian. Type: Yes or No");
            color = scan.nextLine().toUpperCase().trim();
        }

        return color;
    }
}


