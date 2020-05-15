package com.solvd.lab.v2.automation.classes.c9;

import com.solvd.lab.v2.automation.io.exception.UnableToCloseExcepton;
import com.solvd.lab.v2.automation.io.exception.UnableToReadException;
import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;
import com.solvd.lab.v2.automation.io.impl.file.BufferedTextFileReader;
import com.solvd.lab.v2.automation.io.impl.file.PropertyFileReader;
import com.solvd.lab.v2.automation.io.impl.file.StreamTextFileReader;
import com.solvd.lab.v2.automation.io.impl.file.TextFileReader;
import com.solvd.lab.v2.automation.io.impl.file.StreamTextFileWriter;

import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        // 1-st way to init reader
        String path = "src/main/resources/data.txt";
        try {
            System.out.println(new StreamTextFileReader(path).read());
        } catch (UnableToReadException e) {
            System.exit(1);
        }

        // 2-nd way to init reader
        File f = new File(path);
        try {
            System.out.println(new StreamTextFileReader(f).read());
        } catch (UnableToReadException e) {
            System.exit(2);
        }

        // 3-rd way to init reader (buffered reader)
        try {
            String info = new BufferedTextFileReader(f).read();
            Objects.requireNonNull(info, "Data after is null!");

        } catch (UnableToCloseExcepton e) {
            System.exit(3);
        }

        // 4-th way to init reader
        try {
            String s = new TextFileReader("src/main/resources/dots.txt").read();
            System.out.println(s);
        } catch (UnableToReadException e) {
            System.exit(4);
        }

        // TODO: implement point parser
        // TODO: duck typing

        // write backup
        try {
            new StreamTextFileWriter().write("src/main/resources/data2.txt", "Helloooo");
        } catch (UnableToWriteException e) {
            System.exit(4);
        }

        try {
            new StreamTextFileWriter().append("src/main/resources/data2.txt", "Helloooo");
        } catch (UnableToWriteException e) {
            System.exit(5);
        }

        String pathToResources = "src/main/resources/config.properties";

        try {
            PropertyFileReader r = new PropertyFileReader(pathToResources);
            r.read();
            System.out.println(r.getPropertyValue("hostname"));
            System.out.println(r.getPropertyValue("port"));
        } catch (UnableToReadException e) {
            System.exit(6);
        }


    }
}
