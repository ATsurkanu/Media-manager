package com;

import static com.ChoseOption.chooseOption;
import static com.Print.printTheFirstSelectionMenu;

public class Main {


    public static void main(String[] args) {
        //DBTableUtil.createBooksTable(DBConnectionUtil.connect());
        //DBTableUtil.createMoviesTable(DBConnectionUtil.connect());
        //DBTableUtil.createMusicsTable(DBConnectionUtil.connect());
        Book.initBooks();

        printTheFirstSelectionMenu();
        chooseOption(args);
    }


}
