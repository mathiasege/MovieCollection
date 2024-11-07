package dataSource;

import DomainModel.Movie;
import DomainModel.MovieCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File file = new File("MovieList.csv");

    public FileHandler() {
    }

    public void loadList(MovieCollection m) {
        Scanner sc = null;
        // Clear the existing list to avoid duplicates
        m.getMovieCollection().clear();
        try {
            sc = new Scanner(file, StandardCharsets.ISO_8859_1);

        } catch (FileNotFoundException fnfe) {
            System.out.println("could not locate file.");
            throw new RuntimeException(fnfe);

        } catch (IOException e) {
            System.out.println("the program had problems reading the file.");
            throw new RuntimeException(e);
        }
        Movie movieTemp = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(";");
            movieTemp = new Movie(
                    (attributes[0]), // titel
                    (attributes[1]), // director
                    (Integer.parseInt(attributes[2])), // year created
                    (attributes[3]), // inColor
                    (Integer.parseInt(attributes[4])), // lenght
                    (attributes[5]) // genre
            );
            m.getMovieCollection().add(movieTemp);


        }
        sc.close();

    }

    public void saveList(MovieCollection m) {
        try {
            PrintStream output = new PrintStream(new File("MovieList.csv"));

            for (Movie movie : m.getMovieCollection()) {
                output.println(movie.toCSV());
            }
            System.out.println("The list was succesfully saved!");

        } catch (
                FileNotFoundException e) {
            System.out.println("The program encountered a problem when trying to save..");


        }
    }
}
