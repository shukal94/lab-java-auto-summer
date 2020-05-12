package com.solvd.lab.v2.automation.c9;

import com.solvd.lab.v2.automation.c9.exception.UnableToCloseExcepton;
import com.solvd.lab.v2.automation.c9.exception.UnableToReadException;
import com.solvd.lab.v2.automation.c9.exception.UnableToWriteException;
import com.solvd.lab.v2.automation.c9.reader.impl.BufferedTextFileReader;
import com.solvd.lab.v2.automation.c9.reader.impl.PropertyFileReader;
import com.solvd.lab.v2.automation.c9.reader.impl.StreamTextFileReader;
import com.solvd.lab.v2.automation.c9.reader.impl.TextFileReader;
import com.solvd.lab.v2.automation.c9.writer.impl.StreamTextFileWriter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // 1-st way to init reader
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
            System.out.println(new BufferedTextFileReader(f).read());
        } catch (UnableToReadException | UnableToCloseExcepton e) {
            System.exit(3);
        }

        // 4-th way to init reader
        try {
            System.out.println(new TextFileReader(f).read());
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

        try {
            PropertyFileReader r = new PropertyFileReader("src/main/resources/config.properties");
            r.read();
            System.out.println(r.getPropertyValue("hostname"));
        } catch (UnableToReadException e) {
            System.exit(6);
        }


    }
}
