package com;

import static com.ChoseOption.chooseOption;
import static com.Print.printTheFirstSelectionMenu;

public class Main {


    public static void main(String[] args) {
        Book.deserializeBooks();
        Movie.deserializeMovies();
        Music.deserializeMusic();

        printTheFirstSelectionMenu();
        chooseOption(args);
    }


}
