import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);

    public void game(){
        boolean exit = false;
        System.out.println("Welcome to the movie collection program");

        while (!exit){
            System.out.println("Please enter a command:");
            System.out.println("ADD: add a new movie");

            String userChoice = input.nextLine();
           userChoice = userChoice.toUpperCase();

            switch (userChoice){
                case "ADD"-> addMovie();
                default -> System.out.println("Please enter a valid command");
            }
        }
    }

    private void addMovie(){

    }}
