package com;

import java.io.*;

import static com.ChoseOption.chooseOption;
import static com.Print.printTheFirstSelectionMenu;

public class Main {


    public static void main(String[] args) {
        printTheFirstSelectionMenu();
        chooseOption(args);

        String path = "C:" + File.separator + "Manager.txt";


//        try {
//            File f = new File(path);
//            f.getParentFile().mkdirs();
//            if (f.createNewFile()) {
//                System.out.println("File creation successfull.");
//            } else
//                System.out.println("Error while creating File, file already exists in specified path");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        OutputStream outputStream = new FileOutputStream(your_file_name);
//        InputStream inputStream = new FileInputStream(your_file_name);
//    }

    }
}
