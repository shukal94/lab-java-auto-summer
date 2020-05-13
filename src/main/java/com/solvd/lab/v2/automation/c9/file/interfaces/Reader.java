package com.solvd.lab.v2.automation.c9.file.interfaces;

import com.solvd.lab.v2.automation.c9.file.exception.UnableToCloseExcepton;
import com.solvd.lab.v2.automation.c9.file.exception.UnableToReadException;

public interface Reader {
    String read() throws UnableToReadException, UnableToCloseExcepton;
}
