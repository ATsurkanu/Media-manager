package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    private static final long serialVersionUID = 2L;

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
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Please, type a title of the movie.");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            ps.println("Type correct title!");
            addMovie(args);
        }


            for (Movie m : movies
                    ) {
                if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    ps.println("This movie already in the list!");
                    Main.main(args);
                }

            }

        movies.add(new Movie(title));

        ps.println("Movie was add.");

        Main.main(args);

    }

    protected static void addStatusForMovie(String[] args) {
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        int numberOfTheInput = 0;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Please, type a title of the media (like Harry Potter)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title == null) {
            ps.println("Type correct title!");
            addStatusForMovie(args);
        }

        ps.println("Chose status" + "\n" +
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
                    ps.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 2) {
                    b.setStatus(Status.WANT_TO_WATCH);
                    ps.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 3) {
                    b.setStatus(Status.IN_PROGRESS);
                    ps.println("Done!");
                }
            }
        }


        Main.main(args);
    }

    protected static void checkStatusOfMovie(String[] args) {
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Please, type a title of the movie (like Harry Potter)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            ps.println("Type correct title!");
            checkStatusOfMovie(args);
        }

        if (Movie.getMovies().isEmpty()){
            ps.println("No movie with this name!");
        }

        for (Movie m : Movie.getMovies()
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                ps.println(m.getTitle() + " movie status is: ");
            }
        }

        for (Movie b : Movie.getMovies()
                ) {
            if (b.getStatus() == null) {
                ps.println("without status yet.");
            } else {
                ps.println(b.getStatus());
            }
        }

        Main.main(args);
    }
}
