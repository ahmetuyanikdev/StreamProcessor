package com.main;

import com.project.Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Runner {

    static String path1 = "src/main/resources/single-line";
    static String path2 = "src/main/resources/oie.png";
    static String path3 = "src/main/resources/iphone62.mp3";

    public static void main(String [] args) throws Exception{
        Reader reader = new Reader();
        InputStream inputStream = new FileInputStream(new File(path1));
        String output = reader.processInput(inputStream);

        System.out.println(output);

    }
}
