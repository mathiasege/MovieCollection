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
            System.out.println("----------------------");
            System.out.println("Please enter a command:");
            System.out.println("Display: show movies");
            System.out.println("Add: add a new movie");
            System.out.println("Delete: Delete a movie");
            System.out.println("Update: Update a movie");
            System.out.println("End: exit");
            System.out.println("----------------------");

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
        System.out.println("Display movies");
        System.out.println("----------------------");
        System.out.println(controller.displayMovie());
    }

    private void deleteMovie() {
        System.out.println("Delete a movie");
        System.out.println("----------------------");
        System.out.println("Type the name of the movie you would like to remove");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        System.out.println(controller.deleteMovie(movie));
    }

    private void updateMovie() {
        System.out.println("Update a movie");
        System.out.println("----------------------");
        System.out.println("Type the name of the movie you would like to edit");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        Movie oldMovie = controller.findSpecificMovie(movie);
        Movie newMovie = changeMovie(oldMovie);

        controller.updateMovie(oldMovie, newMovie);
    }

    private void addMovie() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insert a movie");
        System.out.println("----------------------");

        System.out.println("name of the movie:");
        String movieName = stringIsNotEmpty(scan.nextLine().trim(), scan);

        System.out.println("name of the director:");
        String movieDirector = stringIsNotEmpty(scan.nextLine().trim(), scan);

        System.out.println("the movie is in color. (yes or no)");
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan);

        System.out.println("name of the genre.");
        String genre = stringIsNotEmpty(scan.nextLine().trim(), scan);

        System.out.println("Length of the movie");
        int length = checkInt(scan.nextInt(), scan);

        System.out.println("Release date:");
        int year = checkInt(scan.nextInt(), scan);

        String addMovie = controller.addMovie(movieName,
                movieDirector,
                year,
                color,
                length,
                genre);

        System.out.println("You just added:\n" + addMovie);
    }

    private Movie changeMovie(Movie movie) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Edit a movie");
        System.out.println("----------------------");

        System.out.println("Movie name: " + movie.getTitle());
        System.out.println("New movie name:");
        movie.setTitle(stringIsNotEmpty(scan.nextLine().trim(), scan));

        System.out.println("Director name: " + movie.getDirector());
        System.out.println("New director name:");
        movie.setDirector(stringIsNotEmpty(scan.nextLine().trim(), scan));

        System.out.println("Movie is in color: " + movie.getColorBoolAsString());
        System.out.println("Is in color, yes or no:");
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan);
        movie.setIsInColorFromString(color);

        System.out.println("Movie genre: " + movie.getGenre());
        System.out.println("New genre:");
        movie.setGenre(stringIsNotEmpty(scan.nextLine().trim(), scan));

        System.out.println("Year created: " + movie.getYearCreated());
        System.out.println("New movie year:");
        movie.setYearCreated(checkInt(scan.nextInt(), scan));

        System.out.println("Movie length: " + movie.getLengthInMinutes());
        System.out.println("New movie length:");
        movie.setLengthInMinutes(checkInt(scan.nextInt(), scan));

        return movie;
    }

    private String stringIsNotEmpty(String value, Scanner scan) {
        while (value.isEmpty()) {
            System.out.println("You must type something.");

            value = scan.nextLine();
        }

        return value;
    }

    private String stringIsYesNo(String color, Scanner scan) {
        while (!color.equals("YES") && !color.equals("NO")) {
            System.out.println("Try again. Type: yes or no");
            color = scan.nextLine().toUpperCase().trim();
        }

        return color;
    }

    private int checkInt(int value, Scanner scan) {
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
}


