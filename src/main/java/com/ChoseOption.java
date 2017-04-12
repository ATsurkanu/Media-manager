package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.Book.addBook;
import static com.Book.addStatusForBook;
import static com.Book.checkStatusOfBook;
import static com.Movie.addMovie;
import static com.Movie.addStatusForMovie;
import static com.Movie.checkStatusOfMovie;
import static com.Music.addMusic;
import static com.Music.addStatusForMusic;
import static com.Music.checkStatusOfMusic;
import static com.Print.printMedia;

public class ChoseOption {
    private static int numberOfInput = 0;
    public static BufferedReader bufferedReader = null;

    protected static void chooseOption(String[] args){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            numberOfInput = Integer.parseInt(bufferedReader.readLine());
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
            addStatusForBook(args);
        } else if (numberOfInput == 5) {
            addStatusForMusic(args);
        } else if (numberOfInput == 6) {
            addStatusForMovie(args);
        } else if (numberOfInput == 7) {
            checkStatusOfBook(args);
        } else if (numberOfInput == 8) {
            checkStatusOfMusic(args);
        } else if (numberOfInput == 9) {
            checkStatusOfMovie(args);
        } else if (numberOfInput == 10) {
            printMedia(args);
        } else if (numberOfInput == 11) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        } else {
            System.out.println("Choose correct number!");
            Main.main(args);
        }
    }




}
