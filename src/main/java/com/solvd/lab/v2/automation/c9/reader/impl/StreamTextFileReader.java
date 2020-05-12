package com.solvd.lab.v2.automation.c9.reader.impl;

import com.solvd.lab.v2.automation.c9.base.BaseReader;
import com.solvd.lab.v2.automation.c9.exception.UnableToReadException;
import com.solvd.lab.v2.automation.c9.interfaces.Reader;

import java.io.*;

public class StreamTextFileReader extends BaseReader implements Reader {

    public StreamTextFileReader(File file) {
        super(file);
    }

    public StreamTextFileReader(String path) {
        super(path);
    }

    public String read() throws UnableToReadException{
        try(FileInputStream fin = new FileInputStream(this.file)) { // try withou resources
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            //return Arrays.toString(buffer); wtf???
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnableToReadException(String.format("Could not read %s!", this.path));
    }
}
