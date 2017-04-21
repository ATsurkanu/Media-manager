package com;

import java.io.*;

public class Print {
    private static BufferedReader reader;

    protected static void printMedia(String[] args) {
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int numberOfTheInput = 0;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Chose media to print" + "\n" +
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
                ps.println("Books is Empty!");
            } else {
                for (Book b : Book.getBooks()
                        ) {
                    ps.print(b.getTitle() + " book status is: ");
                    if (b.getStatus() != null) {
                        ps.println(b.getStatus());
                    } else {
                        ps.println("without status yet.");
                    }
                }
            }
        } else if (numberOfTheInput == 2) {
            if (Movie.getMovies().isEmpty()) {
                ps.println("Movies is empty!");
            } else
                for (Movie m : Movie.getMovies()) {
                    ps.print(m.getTitle() + " movie status is: ");
                    if (m.getStatus() == null) {
                        ps.println("without status yet.");
                    } else {
                        ps.println(m.getStatus());
                    }
                }
        } else if (numberOfTheInput == 3) {
            if (Music.getMusics().isEmpty()) {
                ps.print("Musics is empty!");
            } else {
                for (Music m : Music.getMusics()) {
                    ps.print(m.getTitle() + " music status is: ");
                    if (m.getStatus() == null) {
                        ps.println("without status yet.");
                    } else {
                        ps.println(m.getStatus());
                    }
                }
            }
        } else {
            ps.println("Incorrect number!");
            printMedia(args);
        }

        Main.main(args);
    }

    protected static void printTheFirstSelectionMenu() {
        System.out.println();
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
