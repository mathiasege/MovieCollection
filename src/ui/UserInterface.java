package ui;

import models.Controller;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller;


    //instance of controller class
    public UserInterface() {
        controller = new Controller();
    }


    //|---------------PROGRAM LOOP START-----------|
    public void game() {
        String userChoice = "";
        Scanner input = new Scanner(System.in);
        PrintStream out = System.out;

        out.println("Welcome to the movie collection program.");

        while (!userChoice.equals("END")) {
            out.println("----------------------");
            out.println("Please enter a command:");
            out.println("Display: show movies.");
            out.println("Sort: type what to filter.");
            out.println("Add: add a new movie.");
            out.println("Delete: Delete a movie.");
            out.println("Update: Update a movie.");
            out.println("Search: Search for a movie by its title.");
            out.println("End: exit.");
            out.println("----------------------");

            userChoice = input.nextLine().toUpperCase();

            switch (userChoice) {
                case "DISPLAY" -> displayMovie(out);
                case "SORT" -> sort(out);
                case "ADD" -> addMovie(out);
                case "DELETE" -> deleteMovie(out);
                case "UPDATE" -> updateMovie(out);
                case "SEARCH" -> out.println(searchByName(out));
                case "END" -> out.println("Thank you. Goodbye");
                default -> out.println("Please enter a valid command.");
            }
        }
    }
    //|---------------PROGRAM LOOP END-----------|


    // method to display entries
    private void displayMovie(PrintStream out) {
        out.println("Display movies:");
        out.println("----------------------");
        out.println(controller.displayMovie());
    }


    // method to sort movie entries
    private void sort(PrintStream out) {
        Scanner scan = new Scanner(System.in);
        out.println("You can pick 2.");

        String[] picked = new String[2];

        for (int i = 0; i < picked.length; i++) {
            out.println("Pick what you want to sort:");
            out.println("Options: title, director, yearCreated, isInColor, lengthInMinutes, genre");
            picked[i] = scan.nextLine().trim().toUpperCase();

            if (i == 1) {
                break;
            }

            out.println("Want to pick one more?");
            out.println("Yes or No");

            String oneMore = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan, out);

            if (oneMore.equals("NO")) {
                break;
            }
        }

        // Movies are sorted:
        String sortedMovies = controller.userChoiceSort(picked);
        out.println("Sorted movie list");
        out.println("---------------------");
        out.println(sortedMovies);  // prints the sorted movie list
    }

    //method to delete a selected movie entry
    private void deleteMovie(PrintStream out) {
        out.println("Delete a movie:");
        out.println("----------------------");
        if (controller.getMoviesSorted().isEmpty()) {
            out.println("There are no movies in your collection.");
            return;
        }
        out.println("Type the name of the movie you would like to remove.");
        String movie = new Scanner(System.in).nextLine().toLowerCase();
        out.println(controller.deleteMovie(movie));
    }

    // Method used to launch the update() method.
    // if searched movie is not found, update method is not called.
    private void updateMovie(PrintStream out) {
        out.println("Update a movie");
        out.println("----------------------");
        out.println("Type the name of the movie you would like to edit.");

        //promts the user to define a string, used for searching:
        String movieToUpdate = new Scanner(System.in).nextLine().toLowerCase();

        // a check to see if movie exists.
        String movieExist = controller.findSpecificMovie(movieToUpdate);


        //if else statement to check if the findSpecificMovie() method was able to locate an entry with searched name.
        if (!movieExist.isEmpty()) {
            out.println(movieExist);
        } else {
            // starts update method.
            update(out, movieToUpdate);

        }
    }

    // once movie entry is found, this method is called, to update the entry.
    private void update(PrintStream out, String oldMovie) {
        Scanner scan = new Scanner(System.in);

        out.println("Edit a movie:");
        out.println("----------------------");
        //displays current title of the entry:
        out.println("Old name: " + controller.getMovieTitel() + ".");

        out.println("New movie name:");
        // inserts, if String != null
        String title = checkString(scan.nextLine().trim(), scan, out);

        //displays current director of the entry:
        out.println("Old director name: " + controller.getMovieDirector() + ".");

        out.println("New director name:");
        // inserts, if String != null
        String director = isAString(scan.nextLine().trim(), scan, out);

        //displays current inColor statement of the entry:
        out.println("Old is in color: " + controller.getMovieColor() + ".");

        out.println("Is in color, yes or no:");
        // inserts, if String == Yes eller No
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan, out);

        //displays current genre of the entry:
        out.println("Old genre: " + controller.getMovieGenre() + ".");

        out.println("New genre:");
        // inserts, if String != null
        String genre = isAString(scan.nextLine().trim(), scan, out);

        //displays current year of the entry:
        out.println("Old year created: " + controller.getMovieRelease() + ".");

        out.println("New movie year:");
        // inserts, if int > 0
        int year = checkInt(scan, out);

        //displays current length of the entry:
        out.println("Old length: " + controller.getMovieLength() + ".");

        out.println("New movie length:");
        // inserts, if int > 0
        int length = checkInt(scan, out);


        //if changes are made to the entry, old movie is updated:
        if (!title.equals(controller.getMovieTitel()) ||
                !director.equals(controller.getMovieDirector()) ||
                year != controller.getMovieRelease() ||
                !color.equalsIgnoreCase(controller.getMovieColor()) ||
                length != controller.getMovieLength() ||
                !genre.equals(controller.getMovieGenre())) {

            String updatedMovie = controller.updateMovie(oldMovie,
                    title,
                    director,
                    year,
                    color,
                    length,
                    genre);

            out.println("--------------------------------");
            out.println("Movie updated:");
            out.println(updatedMovie);
        } else { //if no changes are made, this prints:
            out.println("No changes made.");
        }

    }

    // adds movie:
    private void addMovie(PrintStream out) {
        //instance of new scanner
        Scanner scan = new Scanner(System.in);

        out.println("Insert a movie:");
        out.println("----------------------");

        out.println("name of the movie:");
        // inserts, if String != null
        String movieName = checkString(scan.nextLine().trim(), scan, out);

        out.println("name of the director:");
        // inserts, if String != null
        String movieDirector = isAString(scan.nextLine().trim(), scan, out);

        out.println("the movie is in color. (yes or no):");
        // inserts, if String == Yes eller No
        String color = stringIsYesNo(scan.nextLine().toUpperCase().trim(), scan, out);

        out.println("name of the genre:");
        // inserts, if String != null
        String genre = isAString(scan.nextLine().trim(), scan, out);

        out.println("Length of the movie:");
        // inserts, if int > 0
        int length = checkInt(scan, out);

        out.println("Release date:");
        // inserts, if int > 0
        int year = checkInt(scan, out);


        //calls addMovie method, with defined strings:
        String addMovie = controller.addMovie(movieName,
                movieDirector,
                year,
                color,
                length,
                genre);


        //prints movie added
        out.println("You just added:\n" + addMovie);
    }


        //method to check if a string variable is empty.
        //currently only used to make sure that there are no movie entries without titles.
    private String checkString(String value, Scanner scan, PrintStream out) {
        while (value.isEmpty()) {
            out.println("Please enter a movie name");
            value = scan.nextLine();
        }
        return value;
    }

    // controls that inputted value is a string.
    // if it is an integer it promts you to change it to a string.
    // used to make sure we don't get any unwanted inputs while creating a movie entry.
    private String isAString(String value, Scanner scan, PrintStream out) {
        if (isAnInteger(value)) {
            out.println("Please enter a valid Name");
            value = scan.nextLine();
            isAString(value, scan, out);
        }
        return value;
    }


    //checks input to see if it is an integer.
    //helper method to use with isAString() method.
    private boolean isAnInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // check for isInColor
    private String stringIsYesNo(String input, Scanner scan, PrintStream out) {
        // if user input != YES or NO, then the method prompts you to write a valid input.
        while (!input.equals("YES") && !input.equals("NO")) {
            out.println("Try again. Type: yes or no.");
            input = scan.nextLine().toUpperCase().trim();
        }

        return input;
    }

    // Check for min value.
    private int checkInt(Scanner scan, PrintStream out) {
        try {
            //makes sure it's an integer:
            return Integer.parseInt(scan.nextLine());
        } catch (InputMismatchException | NumberFormatException e) {
            out.println("Please enter a valid number.");
            return checkInt(scan, out);
        }
    }
// method used to take a string inputted from the user, to use for searching movies.
    private String searchByName(PrintStream out) {
        Scanner input = new Scanner(System.in);
        out.println("Please enter the name of the movie you wish to search for:");
        return controller.searchByTitle(input.nextLine());
    }
}


