package com.solvd.lab.v2.automation.c9.file.impl;

import com.solvd.lab.v2.automation.c9.file.base.BaseReader;
import com.solvd.lab.v2.automation.c9.file.exception.UnableToReadException;
import com.solvd.lab.v2.automation.c9.file.interfaces.Reader;

import java.io.*;

public class StreamTextFileReader extends BaseReader implements Reader {

    public StreamTextFileReader(File file) {
        super(file);
    }

    public StreamTextFileReader(String path) {
        super(path);
    }

    @Override
    public String read() throws UnableToReadException{
        try(FileInputStream fin = new FileInputStream(this.file)) { // try withou resources
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer);
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnableToReadException(String.format("Could not read %s!", this.path));
    }
}
