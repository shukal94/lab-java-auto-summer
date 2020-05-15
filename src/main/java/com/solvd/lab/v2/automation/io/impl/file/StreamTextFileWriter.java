package com.solvd.lab.v2.automation.io.impl.file;

import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;
import com.solvd.lab.v2.automation.io.interfaces.Writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTextFileWriter implements Writer {


    @Override
    public void append(String path, String text) throws UnableToWriteException {
        File fileTo = new File(path);
        try(FileOutputStream fout = new FileOutputStream(fileTo.getAbsoluteFile(), true)) { // try withou resources
            byte[] buffer = text.getBytes();
            fout.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToWriteException(String.format("Could not write %s!", path));
        }
    }

    @Override
    public void write(String path, String text) throws UnableToWriteException {
        File fileTo = new File(path);
        try(FileOutputStream fout = new FileOutputStream(fileTo.getAbsoluteFile())) { // try withou resources
            byte[] buffer = text.getBytes();
            fout.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToWriteException(String.format("Could not write %s!", path));
        }
    }
}
