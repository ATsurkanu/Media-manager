package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    private String title;
    private Status status;
    private static List<Movie> movies = new ArrayList<Movie>();

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Movie() {

    }

    public Movie(String title) {
        this.title = title;
    }


    public Movie(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    protected static void addMovie(String[] args) {

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, type a title of the movie.");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            addMovie(args);
        }


            for (Movie m : movies
                    ) {
                if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    System.out.println("This movie already in the list!");
                    Main.main(args);
                }

            }

        movies.add(new Movie(title));

        System.out.println("Movie was add.");

        Main.main(args);

    }

    protected static void addStatusForMovie(String[] args) {

        String title = null;
        int numberOfTheInput = 0;
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, type a title of the media (like Harry Potter)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title == null) {
            System.out.println("Type correct title!");
            addStatusForMovie(args);
        }

        System.out.println("Chose status" + "\n" +
                "1. WAS_READ, WAS_WATCHED, WAS_LISTENED" + "\n" +
                "2. WANT_TO_READ, WANT_TO_WATCH, WANT_TO_LISTEN" + "\n" +
                "3. IN_PROGRESS");

        try {
            numberOfTheInput = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Movie b : movies
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                if (b.getStatus() == null && numberOfTheInput == 1) {
                    b.setStatus(Status.WAS_WATCHED);
                    System.out.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 2) {
                    b.setStatus(Status.WANT_TO_WATCH);
                    System.out.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 3) {
                    b.setStatus(Status.IN_PROGRESS);
                    System.out.println("Done!");
                }
            }
        }


        Main.main(args);
    }

    protected static void checkStatusOfMovie(String[] args) {

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, type a title of the movie (like Harry Potter)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            checkStatusOfMovie(args);
        }

        if (Movie.getMovies().isEmpty()){
            System.out.println("No movie with this name!");
        }

        for (Movie m : Movie.getMovies()
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.println(m.getTitle() + " movie status is: ");
            }
        }

        for (Movie b : Movie.getMovies()
                ) {
            if (b.getStatus() == null) {
                System.out.println("without status yet.");
            } else {
                System.out.println(b.getStatus());
            }
        }

        Main.main(args);
    }
}
