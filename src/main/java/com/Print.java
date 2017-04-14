package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print {
    private static BufferedReader reader;

    protected static void printMedia(String[] args) {
        int numberOfTheInput = 0;
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Chose media to print" + "\n" +
                "1. Print all of the books." + "\n" +
                "2. Print all of the movies." + "\n" +
                "3. Print all of the musics.");

        try {
            numberOfTheInput = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numberOfTheInput == 1) {
            if (Book.getBooks().isEmpty()) {
                System.out.println("Books is Empty!");
            } else {
                for (Book b : Book.getBooks()
                        ) {
                    System.out.print(b.getTitle() + " book status is: ");
                }

                for (Book b : Book.getBooks()
                        ) {
                    if (b.getStatus() != null) {
                        System.out.println(b.getStatus());
                    } else {
                        System.out.println("without status yet.");
                    }
                }
            }
        } else if (numberOfTheInput == 2) {
            if (Movie.getMovies().isEmpty()) {
                System.out.println("Movies is empty!");
            } else
                for (Movie m : Movie.getMovies())
                    System.out.println(m.getTitle() + " movie status is: ");
            for (Movie b : Movie.getMovies()
                    ) {
                if (b.getStatus() == null) {
                    System.out.println("without status yet.");
                } else {
                    System.out.println(b.getStatus());
                }
            }
        } else if (numberOfTheInput == 3) {
            if (Music.getMusics().isEmpty()) {
                System.out.println("Musics is empty!");
            } else {
                for (Music m : Music.getMusics()) {
                    System.out.println(m.getTitle() + " music status is: ");
                }
                for (Music b : Music.getMusics()
                        ) {
                    if (b.getStatus() == null) {
                        System.out.println("without status yet.");
                    } else {
                        System.out.println(b.getStatus());
                    }
                }
            }
        } else {
            System.out.println("Incorrect number!");
            printMedia(args);
        }

        Main.main(args);
    }

    protected static void printTheFirstSelectionMenu() {
        System.out.println("Please, choose option by typing correct number:" + "\n" +
                "1. Add book." + "\n" +
                "2. Add music" + "\n" +
                "3. Add movie" + "\n" +
                "4. Add status for a book" + "\n" +
                "5. Add status for a music" + "\n" +
                "6. Add status for a movie" + "\n" +
                "7. Check status of a book" + "\n" +
                "8. Check status of a music" + "\n" +
                "9. Check status of a movie" + "\n" +
                "10. Print media." + "\n" +
                "11. Exit");

    }
}
