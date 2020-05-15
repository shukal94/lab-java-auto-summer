package com.solvd.lab.v2.automation.io.interfaces;

import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;

public interface StreamWriter {
    void write(String path, Packable pkg) throws UnableToWriteException;
}
