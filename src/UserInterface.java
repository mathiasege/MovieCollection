import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner input = new Scanner(System.in);



    public void game(){
        String userChoice = "";
        System.out.println("Welcome to the movie collection program");

        while (!userChoice.equals("END")){
            System.out.println("Please enter a command:");
            System.out.println("ADD: add a new movie.");
            System.out.println("DISPLAY: display all movies in the collection.");
            System.out.println("SEARCH: search for a movie by name");
            System.out.println("END: quit the program.");

            userChoice = input.nextLine();
            userChoice = userChoice.toUpperCase();

            switch (userChoice){
                case "ADD"-> addMovie();
                case "DISPLAY" -> displayAllMovies();
                case "SEARCH" -> searchByName();
                case "END" -> System.out.println("You're exiting the program.");
                default -> System.out.println("Please enter a valid command");
            }
        }
    }

    private void addMovie(){
        System.out.println("Adding a new movie. please enter a title:");
        String title = input.nextLine();
        System.out.println("Please enter the director:");
        String director = input.nextLine();


        System.out.println("Please enter the year of the movie's creation:");
        String yearInput = "x";
        int year = 0;
        while (!isNumeric(yearInput)){
            yearInput = input.nextLine();
            if(!isNumeric(yearInput)){
                System.out.println("Please enter a valid year");
            }else{
                year = Integer.parseInt(yearInput);
            }

        }

        System.out.println("is the movie in color? y/n");
        boolean inColor = false;
        String inColorInput = "";
        while(!inColorInput.equals("y") && !inColorInput.equals("n")){
            inColorInput = input.nextLine();
            if(inColorInput.equals("y")){
                inColor = true;
            }else if(inColorInput.equals("n")){
                inColor = false;
            }else{
                System.out.println("Please enter a valid input");
            }
        }


        System.out.println("How long is the movie? (in minutes)");
        String lengthInput = "x";
        int length = 0;
        while (!isNumeric(lengthInput)){
            lengthInput = input.nextLine();
            if(!isNumeric(lengthInput)){
                System.out.println("Please enter a valid year");
            }else{
                length = Integer.parseInt(lengthInput);
            }

        }

        System.out.println("Which genre is the movie");
        String genre = input.nextLine();


        //making the movie:
        controller.addMovie(title, director, year, inColor, length, genre);

    }

    private void displayAllMovies(){
        ArrayList<String> displayList = controller.displayAllMovies();
        for(String movie : displayList){
            System.out.println(movie);
        }
    }

    private void searchByName(){
        System.out.println("Please enter the name of the movie you wish to search for:");
        String searchTerm = input.nextLine();
        ArrayList<Movie> searchResults = controller.searchByTitle(searchTerm);
        if(searchResults.size() > 0){
            System.out.println(searchResults.size() + "results were found:");
            for(Movie movie : searchResults){
                System.out.println(movie);
            }
            //enabling editing of a movie
            selectMovie(searchResults);



        }else{
            System.out.println("No Results found");
        }
    }

    private void selectMovie(ArrayList<Movie> searchResults){

        Movie selection;
        boolean exit = false;
        while(!exit){
            System.out.println("If you wish to edit one of the movies, type EDIT, followed by the movies name");
            System.out.println("Otherwise, type BACK");
            String userChoice = input.nextLine();
            String[] userChoiceSplit = userChoice.split(" ");
            if(userChoiceSplit.length > 0){
                if(userChoiceSplit[0].toUpperCase().equals("EDIT")){
                    String selectedMovie = reconstructSelection(userChoiceSplit);
                    ArrayList<Movie> results = controller.searchByTitle(selectedMovie);
                    if(results.size() >= 1){
                        selection = results.get(0);
                        editMovie(selection);

                    }
                } else if (userChoiceSplit[0].toUpperCase().equals("BACK")) {
                    exit = true;
                }
            }

        }



    }


    private void editMovie(Movie selection){
        System.out.println("Editing "  + selection.getTitle() + ":");
        System.out.println("Please enter the movie's title:");
        String title = input.nextLine();
        System.out.println("Please enter the director:");
        String director = input.nextLine();


        System.out.println("Please enter the year of the movie's creation:");
        String yearInput = "x";
        int year = 0;
        while (!isNumeric(yearInput)){
            yearInput = input.nextLine();
            if(!isNumeric(yearInput)){
                System.out.println("Please enter a valid year");
            }else{
                year = Integer.parseInt(yearInput);
            }

        }

        System.out.println("is the movie in color? y/n");
        boolean inColor = false;
        String inColorInput = "";
        while(!inColorInput.equals("y") && !inColorInput.equals("n")){
            inColorInput = input.nextLine();
            if(inColorInput.equals("y")){
                inColor = true;
            }else if(inColorInput.equals("n")){
                inColor = false;
            }else{
                System.out.println("Please enter a valid input");
            }
        }


        System.out.println("How long is the movie? (in minutes)");
        String lengthInput = "x";
        int length = 0;
        while (!isNumeric(lengthInput)){
            lengthInput = input.nextLine();
            if(!isNumeric(lengthInput)){
                System.out.println("Please enter a valid year");
            }else{
                length = Integer.parseInt(lengthInput);
            }

        }

        System.out.println("Which genre is the movie");
        String genre = input.nextLine();


        //updating the movie:
        selection.setTitle(title);
        selection.setDirector(director);
        selection.setGenre(genre);
        selection.setInColor(inColor);
        selection.setLengthInMinutes(length);
        selection.setYearCreated(year);
    }

    private String reconstructSelection(String[] splitChoice){
        String itemName = "";
        for(int i=1; i<splitChoice.length; i++){
            if(i == splitChoice.length -1){
                itemName = itemName + splitChoice[i];
            }else {
                itemName = itemName + splitChoice[i] + " ";
            }

        }

        return itemName;
    }


    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
