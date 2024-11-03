import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller;

    public UserInterface() {
        controller = new Controller();
    }

    public void game() {
        String userChoice = "";
        Scanner input = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("Welcome to the movie collection program.");

        while (!userChoice.equals("END")) {
            out.println("----------------------");
            out.println("Please enter a command:");
            out.println("Display: show movies.");
            out.println("Add: add a new movie.");
            out.println("Delete: Delete a movie.");
            out.println("Update: Update a movie.");
            out.println("Search: Search for a movie by its title.");
            out.println("End: exit.");
            out.println("----------------------");

            userChoice = input.nextLine().toUpperCase();

            switch (userChoice) {
                case "DISPLAY" -> displayMovie(out);
                case "ADD" -> addMovie(out);
                case "DELETE" -> deleteMovie(out);
                case "UPDATE" -> updateMovie(out);
                case "SEARCH" -> out.println(searchByName(out));
                case "END" -> out.println("You're ending the game.");
                default -> out.println("Please enter a valid command.");
            }
        }
    }

    private void displayMovie(PrintStream out) {
        out.println("Display movies:");
        out.println("----------------------");
        out.println(controller.displayMovie());
    }

    private void deleteMovie(PrintStream out) {
        out.println("Delete a movie:");
        out.println("----------------------");
        if (controller.getMovies().isEmpty()) {
            out.println("There are no movies in your collection.");
            return;
        }
        out.println("Type the name of the movie you would like to remove.");
        String movie = new Scanner(System.in).nextLine().toLowerCase();
        out.println(controller.deleteMovie(movie));
    }

    // Opdatere film.
    private void updateMovie(PrintStream out) {
        out.println("Update a movie");
        out.println("----------------------");
        out.println("Type the name of the movie you would like to edit.");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        // Kontrollere om filmen eksistere.
        String movieExist = controller.checkSpecificMovie(movie);

        if (!movieExist.isEmpty()) {
            out.println(movieExist);
        } else {
            // Igangsæt update.
            update(out);
        }
    }

    private void update(PrintStream out) {
        Scanner scan = new Scanner(System.in);

        out.println("Edit a movie:");
        out.println("----------------------");


        out.println("Movie name: " + controller.getMovieTitel() + ".");
        out.println("New movie name:");
        // Indsætter, hvis String != null
        controller.setMovieTitel(checkString(scan.nextLine().trim(), scan, out));

        out.println("Director name: " + controller.getMovieDirector() + ".");
        out.println("New director name:");
        // Indsætter, hvis String != null
        controller.setMovieDirector(isAString(scan.nextLine().trim(), scan, out));

        out.println("Movie is in color: " + controller.getMovieColor() + ".");
        out.println("Is in color, yes or no:");
        // Indsætter, hvis String == Yes eller No
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan, out);
        controller.setMovieColor(color);

        out.println("Movie genre: " + controller.getMovieGenre() + ".");
        out.println("New genre:");
        // Indsætter, hvis String != null
        controller.setMovieGenre(isAString(scan.nextLine().trim(), scan, out));

        out.println("Year created: " + controller.getMovieRelease() + ".");
        out.println("New movie year:");
        // Indsætter, hvis int > 0
        controller.setMovieRelease(checkInt(scan, out));

        out.println("Movie length: " + controller.getMovieLength() + ".");
        out.println("New movie length:");
        // Indsætter, hvis int > 0
        controller.setMovieLength(checkInt(scan, out));

        out.println(controller.getCurrentMovie() + ".");
    }

    // Tilføjer film
    private void addMovie(PrintStream out) {
        Scanner scan = new Scanner(System.in);

        out.println("Insert a movie:");
        out.println("----------------------");

        out.println("name of the movie:");
        // Indsætter, hvis String != null
        String movieName = checkString(scan.nextLine().trim(), scan, out);

        out.println("name of the director:");
        // Indsætter, hvis String != null
        String movieDirector = isAString(scan.nextLine().trim(), scan, out);

        out.println("the movie is in color. (yes or no):");
        // Indsætter, hvis String == Yes eller No
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan, out);

        out.println("name of the genre:");
        // Indsætter, hvis String != null
        String genre = isAString(scan.nextLine().trim(), scan, out);

        out.println("Length of the movie:");
        // Indsætter, hvis int > 0
        int length = checkInt(scan, out);

        out.println("Release date:");
        // Indsætter, hvis int > 0
        int year = checkInt(scan, out);

        String addMovie = controller.addMovie(movieName,
                movieDirector,
                year,
                color,
                length,
                genre);

        out.println("You just added:\n" + addMovie);
    }

    private String checkString(String value, Scanner scan, PrintStream out) {
        while (value.isEmpty()) {
            out.println("Please enter a movie name");
            value = scan.nextLine();
        }
        return value;
    }

    // Kontrol for, at der er indtastet noget.
    private String isAString(String value, Scanner scan, PrintStream out) {
        if (isAnInteger(value)) {
            out.println("Please enter a valid Name");
            value = scan.nextLine();
            isAString(value, scan, out);
        }
        return value;
    }

    private boolean isAnInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Kontrol for isInColor
    private String stringIsYesNo(String color, Scanner scan, PrintStream out) {
        // Må ikke være ja eller nej.
        while (!color.equals("YES") && !color.equals("NO")) {
            out.println("Try again. Type: yes or no.");
            color = scan.nextLine().toUpperCase().trim();
        }

        return color;
    }

    // Kontrol for min int.
    private int checkInt(Scanner scan, PrintStream out) {
        // Hvis rigtigt er indtastet.
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (InputMismatchException | NumberFormatException e) {
            out.println("Please enter a valid number.");
            return checkInt(scan, out);
        }
    }


    private String searchByName(PrintStream out) {
        Scanner input = new Scanner(System.in);
        out.println("Please enter the name of the movie you wish to search for:");
        String searchTerm = input.nextLine();
        return controller.searchByTitle(searchTerm);
    }
}


