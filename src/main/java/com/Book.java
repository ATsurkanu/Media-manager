package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
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
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Please, type a title of the book.");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            ps.println("Type correct title!");
            addBook(args);
        }

        for (Book m : books
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                ps.println("This book already in the list!");
                Main.main(args);
            }

        }

        books.add(new Book(title));
        serializeBooks(books);

        ps.println("Book was add.");

        Main.main(args);
    }

    protected static void addStatusForBook(String[] args) {
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
            addStatusForBook(args);
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

        for (Book b : books
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                if (b.getStatus() == null && numberOfTheInput == 1) {
                    b.setStatus(Status.WAS_READ);
                    ps.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 2) {
                    b.setStatus(Status.WANT_TO_READ);
                    ps.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 3) {
                    b.setStatus(Status.IN_PROGRESS);
                    ps.println("Done!");
                }
            }
        }
        serializeBooks(books);

        Main.main(args);
    }

    protected static void checkStatusOfBook(String[] args) {
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        ps.println("Please, type a title of the book (like Harry Potter)");
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            ps.println("Type correct title!");
            checkStatusOfBook(args);
        }

        if (Book.getBooks().isEmpty()) {
            ps.println("No book with this name!");
        }

        for (Book b : Book.getBooks()
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                ps.print(b.getTitle() + " book status is: ");
                if (b.getStatus() != null) {
                    ps.println(b.getStatus());
                } else {
                    ps.println("without status yet.");
                }
            }
        }

        Main.main(args);
    }

    private static void serializeBooks(List<Book> books) {
        if (books.isEmpty()) {
            return;
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("C:\\Windows\\Temp\\books.txt"))) {
            oos.writeInt(books.size());

            for (Book book : books
                    ) {
                oos.writeObject(book);
            }
            System.out.println("Writing Done!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected static List<Book> deserializeBooks() {
        File f = new File("C:\\Windows\\Temp\\books.txt");
        if (!f.exists()) {
            return Collections.emptyList();
        }

        List<Book> bookList = null;
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("C:\\Windows\\Temp\\books.txt"))) {
            int size = ois.readInt();

            bookList = new ArrayList<>(size);
            for (int i = 0; i < size; i++)
                bookList.add((Book) ois.readObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return books = bookList;
    }
}
