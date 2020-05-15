package com.solvd.lab.v2.automation.io.interfaces;

import com.solvd.lab.v2.automation.io.exception.UnableToReadException;

public interface StreamReader {
    Packable read() throws UnableToReadException;
}
