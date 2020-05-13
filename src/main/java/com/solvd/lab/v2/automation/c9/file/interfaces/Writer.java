package com.solvd.lab.v2.automation.c9.file.interfaces;

import com.solvd.lab.v2.automation.c9.file.exception.UnableToWriteException;

public interface Writer {
    void write(String path, String text) throws UnableToWriteException;
    void append(String path, String text) throws UnableToWriteException;
}
