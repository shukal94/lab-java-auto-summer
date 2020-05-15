package com.solvd.lab.v2.automation.io.impl.stream;

import com.solvd.lab.v2.automation.io.base.BaseReader;
import com.solvd.lab.v2.automation.io.exception.UnableToReadException;
import com.solvd.lab.v2.automation.io.interfaces.Packable;
import com.solvd.lab.v2.automation.io.interfaces.StreamReader;

import java.io.*;

public class ObjectReader extends BaseReader implements StreamReader {
    public ObjectReader(File file) {
        super(file);
    }

    public ObjectReader(String path) {
        super(path);
    }

    @Override
    public Packable read() throws UnableToReadException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.file.getAbsoluteFile()))) {
            return (Packable) ois.readObject();
        } catch (EOFException e) {
            // do nothing :)
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new UnableToReadException("Could not read object!");
        }
    }
}
