package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Music implements Serializable{
    private String title;
    private Status status;
    private static List<Music> musics = new ArrayList<Music>();

    private static BufferedReader reader;

    public Music() {

    }

    public Music(String title) {
        this.title = title;
    }

    public Music(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public static List<Music> getMusics() {
        return musics;
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

    protected static void addMusic(String[] args) {

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

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


        for (Music m : musics
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.println("This music already in the list!");
                Main.main(args);
            }

        }

        musics.add(new Music(title));

        System.out.println("Music was add.");

        Main.main(args);

    }

    protected static void addStatusForMusic(String[] args) {
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
            addStatusForMusic(args);
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


        Main.main(args);
    }

    protected static void checkStatusOfMusic(String[] args) {

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, type a title of the music (like Ariya)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            System.out.println("Type correct title!");
            checkStatusOfMusic(args);
        }

        if (Music.getMusics().isEmpty()) {
            System.out.println("No music with this name!");
        }

        for (Music m : Music.getMusics()
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                System.out.println(m.getTitle() + " music status is: ");
            }
        }

        for (Music b : Music.getMusics()
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
