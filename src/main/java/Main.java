import ui.UserInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Hvis der ingen fil er. Kan den ikke kører.
        try {
            UserInterface ui = new UserInterface();
            ui.game();
        } catch (FileNotFoundException e) {
            System.out.println("Du mangler movies.txt for at kører programmet.");
        }
    }
}