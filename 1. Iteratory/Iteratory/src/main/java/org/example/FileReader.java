package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static ArrayList<String> getContentAsArray(String path) {
        ArrayList<String> arr = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new File(path));
            while (reader.hasNextLine())
                arr.add(reader.nextLine());
            reader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return arr;
    }

}
