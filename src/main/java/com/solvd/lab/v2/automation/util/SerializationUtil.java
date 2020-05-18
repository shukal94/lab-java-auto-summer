package com.solvd.lab.v2.automation.util;

import com.solvd.lab.v2.automation.io.exception.UnableToReadException;
import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;
import com.solvd.lab.v2.automation.io.impl.stream.ObjectReader;
import com.solvd.lab.v2.automation.io.impl.stream.ObjectWriter;
import com.solvd.lab.v2.automation.io.interfaces.Packable;

public class SerializationUtil {
    private static final String DATA_FILE_PATH1 = System.getProperty("user.dir") + "/src/main/resources/client1";
    private static final String DATA_FILE_PATH2 = System.getProperty("user.dir") + "/src/main/resources/client2";
    private static final String DATA_FILE_PATH_RESPONSE1 = System.getProperty("user.dir") + "/src/main/resources/serial_response1";
    private static final String DATA_FILE_PATH_RESPONSE2 = System.getProperty("user.dir") + "/src/main/resources/serial_response2";

    public static ObjectReader getReaderResponse1() {
        return READER_RESPONSE1;
    }

    public static ObjectReader getReaderResponse2() {
        return READER_RESPONSE2;
    }

    public static ObjectReader getREADER1() {
        return READER1;
    }

    public static ObjectReader getREADER2() {
        return READER2;
    }

    private static final ObjectReader READER1 = new ObjectReader(DATA_FILE_PATH1);
    private static final ObjectReader READER2 = new ObjectReader(DATA_FILE_PATH2);
    private static final ObjectReader READER_RESPONSE1 = new ObjectReader(DATA_FILE_PATH_RESPONSE1);
    private static final ObjectReader READER_RESPONSE2 = new ObjectReader(DATA_FILE_PATH_RESPONSE2);

    public static void writeObject(Packable obj, String path) {
        try {
            new ObjectWriter().write(path, obj);
        } catch (UnableToWriteException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to write!", path));
        }
    }

    public static Packable readObject(ObjectReader objr) {
        try {
            return objr.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to read!", objr.getPath()));
        }

    }

    public static Packable readResponse(ObjectReader objr) {
        try {
            return objr.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to read!", objr.getPath()));
        }

    }

    public static void writeResponse(Packable obj, ObjectReader objr) {
        try {
            new ObjectWriter().write(objr.getPath(), obj);
        } catch (UnableToWriteException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to write!", objr.getPath()));
        }
    }

}
