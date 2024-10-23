import java.util.Scanner;

public class UserInterface {

    private Controller controller = new Controller();

    public void game() {
        String userChoice = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the movie collection program");

        while (!userChoice.equals("END")) {
            System.out.println("Please enter a command:");
            System.out.println("ADD: add a new movie");

            userChoice = input.nextLine().toUpperCase();

            switch (userChoice) {
                case "DISPLAY" -> displayMovie();
                case "ADD" -> addMovie();
                case "DELETE" -> deleteMovie();
                case "Update" -> updateMovie();
                case "END" -> System.out.println("You're ending the game.");
                default -> System.out.println("Please enter a valid command");
            }
        }
    }

    private void displayMovie(){
        System.out.println(controller.displayMovie());
    }

    private void addMovie() {
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        System.out.println("name of the movie.");
        String movieName = scanString.nextLine();

        System.out.println("name of the director.");
        String movieDirector = scanString.nextLine();

        System.out.println("year created.");
        int year = scanInt.nextInt();

        System.out.println("the movie is in color. Yes or No");
        String temp = scanString.nextLine().toUpperCase();

        boolean color = false;
        if(temp.equals("YES")){
            color = true;
        }

        System.out.println("Length of the movie");
        int length = scanInt.nextInt();

        System.out.println("name of the genre.");
        String genre = scanString.nextLine();

        controller.addMovie(movieName,
                movieDirector,
                year,
                color,
                length,
                genre);
    }

    private void deleteMovie(){
        System.out.println("Type the name of the movie you would like to remove");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

        controller.deleteMovie(movie);
    }

    private void updateMovie(){
        System.out.println("Type the name of the movie you would like to edit");
        String movie = new Scanner(System.in).nextLine().toLowerCase();

    }
}


