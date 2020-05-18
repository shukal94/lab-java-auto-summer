package com.solvd.lab.v2.automation.util;

import com.solvd.lab.v2.automation.io.exception.UnableToReadException;
import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;
import com.solvd.lab.v2.automation.io.impl.stream.ObjectReader;
import com.solvd.lab.v2.automation.io.impl.stream.ObjectWriter;
import com.solvd.lab.v2.automation.io.interfaces.Packable;

public class SerializationUtil {
    private static final String DATA_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/serial";
    private static final String DATA_FILE_PATH_RESPONSE = System.getProperty("user.dir") + "/src/main/resources/serial_response";

    private static final ObjectReader READER = new ObjectReader(DATA_FILE_PATH);
    private static final ObjectReader READER_RESPONSE = new ObjectReader(DATA_FILE_PATH_RESPONSE);


    public static void writeObject(Packable obj) {
        try {
            new ObjectWriter().write(DATA_FILE_PATH, obj);
        } catch (UnableToWriteException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to write!", DATA_FILE_PATH));
        }
    }

    public static Packable readObject() {
        try {
            return READER.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to read!", DATA_FILE_PATH));
        }

    }

    public static Packable readResponse() {
        try {
            return READER_RESPONSE.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to read!", DATA_FILE_PATH_RESPONSE));
        }

    }

    public static void writeResponse(Packable obj) {
        try {
            new ObjectWriter().write(DATA_FILE_PATH_RESPONSE, obj);
        } catch (UnableToWriteException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to write!", DATA_FILE_PATH_RESPONSE));
        }
    }

}
