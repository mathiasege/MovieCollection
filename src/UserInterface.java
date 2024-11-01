import java.util.ArrayList;
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
        System.out.println("Welcome to the movie collection program.");

        while (!userChoice.equals("END")) {
            System.out.println("----------------------");
            System.out.println("Please enter a command:");
            System.out.println("Display: show movies.");
            System.out.println("Add: add a new movie.");
            System.out.println("Save: save current movie collection");
            System.out.println("Load: loads saved list");
            System.out.println("Delete: Delete a movie.");
            System.out.println("Update: Update a movie.");
            System.out.println("Search: Search for a movie by its title.");
            System.out.println("End: exit.");
            System.out.println("----------------------");

            userChoice = input.nextLine().toUpperCase();

            switch (userChoice) {
                case "DISPLAY" -> displayMovie();
                case "ADD" -> addMovie();
                case "SAVE" -> saveList();
                case "LOAD" -> loadList();
                case "DELETE" -> deleteMovie();
                case "UPDATE" -> updateMovie();
                case "SEARCH" -> System.out.println(searchByName());
                case "END" -> System.out.println("You're ending the game.");
                default -> System.out.println("Please enter a valid command.");
            }
        }
    }

    private void saveList(){
        System.out.println("Movie list is being saved...");
        System.out.println("----------------------");
        controller.saveList(controller.getMovieCollection());
    }

    private void loadList(){
        System.out.println("Loading list...");
        System.out.println("----------------------");
        controller.loadList();
    }

    private void displayMovie() {
        System.out.println("Display movies:");
        System.out.println("----------------------");
        System.out.println(controller.displayMovie());
    }

    private void deleteMovie() {
        System.out.println("Delete a movie:");
        System.out.println("----------------------");
        System.out.println("Type the name of the movie you would like to remove.");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        System.out.println(controller.deleteMovie(movie));
    }

    // Opdatere film.
    private void updateMovie() {
        System.out.println("Update a movie");
        System.out.println("----------------------");
        System.out.println("Type the name of the movie you would like to edit.");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        // Kontrollere om filmen eksistere.
        String movieExist = controller.checkSpecificMovie(movie);
        if(!movieExist.isEmpty()){
            System.out.println(movieExist);
        }else {
            // Igangsæt update.
            update();
        }
    }
    private void update() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Edit a movie:");
        System.out.println("----------------------");

        System.out.println("Movie name: " + controller.getMovieTitel() + ".");
        System.out.println("New movie name:");
        // Indsætter, hvis String != null
        controller.setMovieTitel(stringIsNotEmpty(scan.nextLine().trim(), scan));

        System.out.println("Director name: " + controller.getMovieDirector() + ".");
        System.out.println("New director name:");
        // Indsætter, hvis String != null
        controller.setMovieDirector(stringIsNotEmpty(scan.nextLine().trim(), scan));

        System.out.println("Movie is in color: " + controller.getMovieColor() + ".");
        System.out.println("Is in color, yes or no:");
        // Indsætter, hvis String == Yes eller No
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan);
        controller.setMovieColor(color);

        System.out.println("Movie genre: " + controller.getMovieGenre() + ".");
        System.out.println("New genre:");
        // Indsætter, hvis String != null
        controller.setMovieGenre(stringIsNotEmpty(scan.nextLine().trim(), scan));

        System.out.println("Year created: " + controller.getMovieRelease() + ".");
        System.out.println("New movie year:");
        // Indsætter, hvis int > 0
        controller.setMovieRelease(checkInt(scan));

        System.out.println("Movie length: " + controller.getMovieLength() + ".");
        System.out.println("New movie length:");
        // Indsætter, hvis int > 0
        controller.setMovieLength(checkInt(scan));

        System.out.println(controller.getCurrentMovie() + ".");
    }

    // Tilføjer film
    private void addMovie() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insert a movie:");
        System.out.println("----------------------");

        System.out.println("name of the movie:");
        // Indsætter, hvis String != null
        String movieName = stringIsNotEmpty(scan.nextLine().trim(), scan);

        System.out.println("name of the director:");
        // Indsætter, hvis String != null
        String movieDirector = stringIsNotEmpty(scan.nextLine().trim(), scan);

        System.out.println("the movie is in color. (yes or no):");
        // Indsætter, hvis String == Yes eller No
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan);

        System.out.println("name of the genre:");
        // Indsætter, hvis String != null
        String genre = stringIsNotEmpty(scan.nextLine().trim(), scan);

        System.out.println("Length of the movie:");
        // Indsætter, hvis int > 0
        int length = checkInt(scan);

        System.out.println("Release date:");
        // Indsætter, hvis int > 0
        int year = checkInt(scan);

        String addMovie = controller.addMovie(movieName,
                movieDirector,
                year,
                color,
                length,
                genre);

        System.out.println("You just added:\n" + addMovie);
    }

    // Kontrol for, at der er indtastet noget.
    private String stringIsNotEmpty(String value, Scanner scan) {
        while (value.isEmpty()) {
            System.out.println("You must type something.");

            value = scan.nextLine();
        }

        return value;
    }

    // Kontrol for isInColor
    private String stringIsYesNo(String color, Scanner scan) {
        // Må ikke være ja eller nej.
        while (!color.equals("YES") && !color.equals("NO")) {
            System.out.println("Try again. Type: yes or no.");
            color = scan.nextLine().toUpperCase().trim();
        }

        return color;
    }

    // Kontrol for min int.
    private int checkInt(Scanner scan) {
        // Hvis rigtigt er indtastet.
        try {
            int length = Integer.parseInt(scan.nextLine());
            return length;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            return checkInt(scan);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return checkInt(scan);
        }
    }


    private String searchByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the movie you wish to search for:");
        String searchTerm = input.nextLine();
        return controller.searchByTitle(searchTerm);
    }
}


