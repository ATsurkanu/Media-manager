package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Music implements Serializable{
    private static final long serialVersionUID = 3L;

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
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Please, type a title of the music.");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            ps.println("Type correct title!");
            addMusic(args);
        }


        for (Music m : musics
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                ps.println("This music already in the list!");
                Main.main(args);
            }

        }

        musics.add(new Music(title));

        ps.println("Music was add.");

        Main.main(args);

    }

    protected static void addStatusForMusic(String[] args) {
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
            addStatusForMusic(args);
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

        for (Music b : musics
                ) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                if (b.getStatus() == null && numberOfTheInput == 1) {
                    b.setStatus(Status.WAS_LISTENED);
                    ps.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 2) {
                    b.setStatus(Status.WANT_TO_LISTEN);
                    ps.println("Done!");
                } else if (b.getStatus() == null && numberOfTheInput == 3) {
                    b.setStatus(Status.IN_PROGRESS);
                    ps.println("Done!");
                }

            }
        }


        Main.main(args);
    }

    protected static void checkStatusOfMusic(String[] args) {
        PrintStream ps = null;

        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String title = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        ps.println("Please, type a title of the music (like Ariya)");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (title.isEmpty()) {
            ps.println("Type correct title!");
            checkStatusOfMusic(args);
        }

        if (Music.getMusics().isEmpty()) {
            ps.println("No music with this name!");
        }

        for (Music m : Music.getMusics()
                ) {
            if (m.getTitle().toLowerCase().equals(title.toLowerCase())) {
                ps.println(m.getTitle() + " music status is: ");
            }
        }

        for (Music b : Music.getMusics()
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
