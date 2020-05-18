package com.solvd.lab.v2.automation.io.impl.stream;

import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;
import com.solvd.lab.v2.automation.io.interfaces.Packable;
import com.solvd.lab.v2.automation.io.interfaces.StreamWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter implements StreamWriter {
    @Override
    public void write(String path, Packable pkg) throws UnableToWriteException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(pkg);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToWriteException("Unable to write obj");
        }
    }
}
