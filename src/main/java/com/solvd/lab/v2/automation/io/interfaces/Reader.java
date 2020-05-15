package com.solvd.lab.v2.automation.io.interfaces;

import com.solvd.lab.v2.automation.io.exception.UnableToCloseExcepton;
import com.solvd.lab.v2.automation.io.exception.UnableToReadException;

public interface Reader {
    String read() throws UnableToReadException, UnableToCloseExcepton;
}
