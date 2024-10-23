import java.util.Scanner;

public class UserInterface {

    private Scanner input = new Scanner(System.in);

    public void game(){
        String userChoice = "";
        System.out.println("Welcome to the movie collection program");

        while (!userChoice.equals("END")){
            System.out.println("Please enter a command:");
            System.out.println("ADD: add a new movie");

            userChoice = input.nextLine();
            userChoice.toUpperCase();

            switch (userChoice){
                case "ADD"-> addMovie();
                case "END" -> System.out.println("You're ending the game.");
                default -> System.out.println("Please enter a valid command");
            }
        }
    }

    private void addMovie(){

    }}
