package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int numberOfInput = 0;

    private static List<Book> books = new ArrayList<Book>();
    private static List<Movie> movies = new ArrayList<Movie>();
    private static List<Music> musics = new ArrayList<Music>();

    public static BufferedReader reader = null;

    public static void main(String[] args) {
        printTheFirstSelectionMenu();

        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            numberOfInput = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numberOfInput == 1) {
            addBook(args);
        } else if (numberOfInput == 2) {
            addMusic(args);
        } else if (numberOfInput == 3) {
            addMovie(args);
        } else if (numberOfInput == 4) {
            checkStatus(args);
        } else if (numberOfInput == 5) {
            addStatus(args);
        } else if (numberOfInput == 6) {
            printMedia(args);
        } else if (numberOfInput == 7) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        } else {
            System.out.println("Choose correct number!");
            main(args);
        }


    }

    private static void printMedia(String[] args) {
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
            for (Book b : books
                    ) {
                System.out.println(b.getTitle() + ", status: " + b.getStatus());
            }
        } else if (numberOfTheInput == 2) {
            for (Movie m : movies
                    ) {
                System.out.println(m.getTitle() + ", status: " + m.getStatus());
            }
        } else if (numberOfTheInput == 3) {
            for (Music m : musics
                    ) {
                System.out.println(m.getTitle() + ", status: " + m.getStatus());
            }
        } else {
            System.out.println("Incorrect number!");
            printMedia(args);
        }


        main(args);
    }

    private static void addStatus(String[] args) {
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
            addStatus(args);
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

        for (Book b : books
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                if (b.getStatus() == null && numberOfTheInput == 1) {
                    b.setStatus(Status.WAS_READ);
                    System.out.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 2) {
                    b.setStatus(Status.WANT_TO_READ);
                    System.out.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 3) {
                    b.setStatus(Status.IN_PROGRESS);
                    System.out.println("Done!");
                }
            }
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

        for (Music b : musics
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                if (b.getStatus() == null && numberOfTheInput == 1) {
                    b.setStatus(Status.WAS_LISTENED);
                    System.out.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 2) {
                    b.setStatus(Status.WANT_TO_LISTEN);
                    System.out.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 3) {
                    b.setStatus(Status.IN_PROGRESS);
                    System.out.println("Done!");
                }

            }
        }

        main(args);
    }

    private static void checkStatus(String[] args) {
        String title = null;
        System.out.println("Please, type a title of the media (like Harry Potter)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            checkStatus(args);
        }

        for (Book b : books
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.println(b.getTitle() + " book status " + b.getStatus());
            }
        }

        for (Movie m : movies
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.println(m.getTitle() + " book status " + m.getStatus());
            }
        }

        for (Music m : musics
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.println(m.getTitle() + " book status " + m.getStatus());
            }
        }

        main(args);
    }

    private static void addMusic(String[] args) {
        String title = null;
        System.out.println("Please, type a title of the music.");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            addMusic(args);
        }

        if (title != null) {
            for (Music m : musics
                    ) {
                if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    System.out.println("This music already in the list!");
                    main(args);
                }

            }

        }

        musics.add(new Music(title));
        System.out.println("Music was add.");

        main(args);

    }

    private static void addMovie(String[] args) {
        String title = null;
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

        if (title != null) {
            for (Movie m : movies
                    ) {
                if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    System.out.println("This movie already in the list!");
                    main(args);
                }

            }

        }

        movies.add(new Movie(title));
        System.out.println("Movie was add.");

        main(args);

    }

    private static void addBook(String[] args) {
        String title = null;
        System.out.println("Please, type a title of the book.");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            addBook(args);
        }

        if (title != null) {
            for (Book m : books
                    ) {
                if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    System.out.println("This book already in the list!");
                    main(args);
                }

            }

        }

        books.add(new Book(title));
        System.out.println("Book was add.");

        main(args);

    }


    private static void printTheFirstSelectionMenu() {
        System.out.println("Please, choose option by typing correct number:" + "\n" +
                "1. Add book." + "\n" +
                "2. Add music" + "\n" +
                "3. Add movie" + "\n" +
                "4. Check status" + "\n" +
                "5. Add status" + "\n" +
                "6. Print media." + "\n" +
                "7. Exit");

    }
}
