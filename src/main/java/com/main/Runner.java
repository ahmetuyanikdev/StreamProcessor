package com.main;

import com.project.Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Runner {

    static String path1 = "src/main/resources/single-line";
    static String path2 = "src/main/resources/oie.png";

    public static void main(String [] args) throws Exception{
        Reader reader = new Reader();
        InputStream inputStream = new FileInputStream(new File(path1));
        String output = reader.processInput(inputStream);

        System.out.println(output);

        InputStream inputStream1 = new FileInputStream(new File(path1));
        System.out.println("/////----/////");
        reader.processNormal(inputStream1);
    }
}
