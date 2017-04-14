package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{
    private String title;
    private Status status;
    private static List<Book> books = new ArrayList<Book>();

    private static BufferedReader reader;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, Status status) {
        this.title = title;
        this.status = status;
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

    public static List<Book> getBooks() {
        return books;
    }

    protected static void addBook(String[] args) {
        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

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


            for (Book m : books
                    ) {
                if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    System.out.println("This book already in the list!");
                    Main.main(args);
                }

            }

        books.add(new Book(title));

        System.out.println("Book was add.");

        Main.main(args);

    }

    protected static void addStatusForBook(String[] args) {


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
            addStatusForBook(args);
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



        Main.main(args);
    }

    protected static void checkStatusOfBook(String[] args) {

        String title = null;
        System.out.println("Please, type a title of the book (like Harry Potter)");
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            checkStatusOfBook(args);
        }

        if (Book.getBooks().isEmpty()){
            System.out.println("No book with this name!");
        }

        for (Book b : Book.getBooks()
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.print(b.getTitle() + " book status is: ");
            }
        }

        for (Book b : Book.getBooks()
                ) {
            if (b.getStatus() != null) {
                System.out.println(b.getStatus());
            } else {
                System.out.println("without status yet.");
            }
        }

        Main.main(args);
    }


}
