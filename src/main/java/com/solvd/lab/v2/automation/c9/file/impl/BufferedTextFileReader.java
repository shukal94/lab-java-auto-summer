package com.solvd.lab.v2.automation.c9.file.impl;

import com.solvd.lab.v2.automation.c9.file.base.BaseReader;
import com.solvd.lab.v2.automation.c9.file.exception.UnableToCloseExcepton;
import com.solvd.lab.v2.automation.c9.file.interfaces.Reader;

import java.io.*;

public class BufferedTextFileReader extends BaseReader implements Reader {

    public BufferedTextFileReader(File file) {
        super(file);
    }

    public BufferedTextFileReader(String path) {
        super(path);
    }

    public String read() throws UnableToCloseExcepton {
        BufferedReader objReader = null;
        StringBuilder sb = new StringBuilder();
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(this.path));

            while ((strCurrentLine = objReader.readLine()) != null) {

                sb.append(strCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new UnableToCloseExcepton("Unable to close");
            }
        }
        return sb.toString();
    }
}
