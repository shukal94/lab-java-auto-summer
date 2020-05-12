package com.solvd.lab.v2.automation.c9.interfaces;

import com.solvd.lab.v2.automation.c9.exception.UnableToCloseExcepton;
import com.solvd.lab.v2.automation.c9.exception.UnableToReadException;

public interface Reader {
    String read() throws UnableToReadException, UnableToCloseExcepton;
}
