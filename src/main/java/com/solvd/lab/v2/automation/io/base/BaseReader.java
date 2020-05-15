package com.solvd.lab.v2.automation.io.base;

import java.io.File;

public abstract class BaseReader {
    protected File file;
    protected String path;

    public BaseReader(File file) {
        this.file = file;
        this.path = file.getAbsolutePath();
    }

    public BaseReader(String path) {
        file = new File(path);
        this.path = file.getAbsolutePath();
    }

    public String getPath() {
        return path;
    }
}
